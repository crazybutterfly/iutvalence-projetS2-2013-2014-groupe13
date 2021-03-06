package utils;

import gamedatas.Frame;
import gamedatas.GameMode;
import gamedatas.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

/**
 *
 * @author WOERLY-MOUSSIER Joachim <joachim.woerly-moussier@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public class GameInformationLoaderFromFile {

    /**
     * création d'un lecteur pour récupérer les données entrées par le joueur
     */
    private BufferedReader fileReader;

    /**
     * Creates a file reader.
     *
     */
    public GameInformationLoaderFromFile()
    {

    }
    /*-----------------CLASS FUNCTIONS---------------*/

    public static boolean fileExists(String fileLocation)
    {
        try
        {
            File file = new File(fileLocation);
            if (file.exists() && !file.isDirectory())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (NullPointerException e)
        {
            return false;
        }
    }

    /*-------------------------MAP FUNCTIONS----------------------*/
    /**
     * Creates a map from the file read.
     *
     * @param fileLocation
     *
     * @return a map.
     */
    public static ValidFileRapport isMapFileValid(String fileLocation)
    {

        ValidFileRapport mapStatus = new ValidFileRapport();

        try
        {
            BufferedReader fileTester = new BufferedReader(new FileReader(fileLocation));
            int mapXSizeTest = Integer.parseInt(fileTester.readLine());
            int mapYSizeTest = Integer.parseInt(fileTester.readLine());
            if ((mapXSizeTest > Map.MAX_X_SIZE) || (mapYSizeTest > Map.MAX_Y_SIZE))
            {
                mapStatus.invalidFilerapport = "erreur de dimension de la map";
                return mapStatus;
            }

            String line = fileTester.readLine();
            int index = 3;
            while ((line != null) && (!"".equals(line)))
            {

                String[] parts = line.split("\\s");
                if ((parts[0].charAt(0) != 'R') && (parts[0].charAt(0) != 'C'))
                {
                    mapStatus.invalidFilerapport = "erreur R && C ligne " + index;
                    return mapStatus;
                }
                if (parts[0].charAt(0) == 'R')
                {
                    if ((Integer.parseInt(parts[1]) > mapXSizeTest) || (Integer.parseInt(parts[1]) < 0))
                    {
                        mapStatus.invalidFilerapport = "erreur premier param rectangle ligne " + index;
                        return mapStatus;
                    }
                    if ((Integer.parseInt(parts[2]) > mapYSizeTest))
                    {
                        mapStatus.invalidFilerapport = "erreur second param rectangle ligne : " + index + ", param " + Integer.parseInt(parts[2]) + "supérieur à " + mapYSizeTest;
                        return mapStatus;
                    }

                    if (Integer.parseInt(parts[2]) < 0)
                    {
                        mapStatus.invalidFilerapport = "erreur second param rectangle ligne : " + index + ",inferieur à 0 ";
                        return mapStatus;
                    }
                    if ((Integer.parseInt(parts[3]) > mapXSizeTest) || (Integer.parseInt(parts[3]) < 0))
                    {
                        mapStatus.invalidFilerapport = "erreur troisième param rectangle ligne " + index;
                        return mapStatus;
                    }
                    if ((Integer.parseInt(parts[4]) > mapYSizeTest) || (Integer.parseInt(parts[4]) < 0))
                    {
                        mapStatus.invalidFilerapport = "erreur quatrième param rectangle ligne " + index;
                        return mapStatus;
                    }
                    if ((!parts[5].equals("W")) && (!parts[5].equals("F")) && (!parts[5].equals("S")) && (!parts[5].equals("G")))
                    {
                        mapStatus.invalidFilerapport = "erreur format case ligne " + index;
                        return mapStatus;
                    }
                }
                else if (parts[0].charAt(0) == 'C')
                {
                    if ((Integer.parseInt(parts[1]) <= Integer.parseInt(parts[3])) || (Integer.parseInt(parts[1]) >= mapXSizeTest - Integer.parseInt(parts[3])))
                    {
                        mapStatus.invalidFilerapport = "erreur premier param cercle ligne " + index;
                        return mapStatus;
                    }
                    if ((Integer.parseInt(parts[2]) <= Integer.parseInt(parts[3])) || (Integer.parseInt(parts[2]) >= mapXSizeTest - Integer.parseInt(parts[3])))
                    {
                        mapStatus.invalidFilerapport = "erreur second param cercle ligne " + index;
                        return mapStatus;
                    }
                    if ((!parts[4].equals("W")) && (!parts[4].equals("F")) && (!parts[4].equals("S")) && (!parts[4].equals("G")))
                    {
                        mapStatus.invalidFilerapport = "erreur format case ligne " + index;
                        return mapStatus;
                    }
                }

                line = fileTester.readLine();
            }
        }
        catch (IOException e)
        {
            mapStatus.invalidFilerapport = "Erreur de lecture de fichier";
            return mapStatus;
        }
        mapStatus.invalidFilerapport = "Fichier valide";
        mapStatus.fileIsValid = true;
        return mapStatus;
    }

    public static Map loadMapFromFile(String fileLocation)
    {
        /**
         * création d'un lecteur pour récupérer les données entrées par le
         * joueur
         */

        try
        {
            int mapXSize;
            int mapYSize;
            BufferedReader fileReader;
            fileReader = new BufferedReader(new FileReader(fileLocation));

            String mapXSizeText = fileReader.readLine();
            if (mapXSizeText == null)
            {
                mapXSize = Map.STANDARD_X_SIZE_VALUE;
            }
            else
            {
                mapXSize = Integer.parseInt(mapXSizeText);
            }

            String mapYSizeText = fileReader.readLine();
            if (mapYSizeText == null)
            {
                mapYSize = Map.STANDARD_Y_SIZE_VALUE;
            }
            else
            {
                mapYSize = Integer.parseInt(mapYSizeText);
            }

            Map map = new Map(mapXSize, mapYSize);

            String line = fileReader.readLine();

            while ((line != null) && (!"".equals(line)))
            {

                String[] parts = line.split("\\s");
                if (parts[0].charAt(0) == 'R')
                {
                    int xStartFrame = Integer.parseInt(parts[1]);
                    int yStartFrame = Integer.parseInt(parts[2]);
                    int width = Integer.parseInt(parts[3]);
                    int height = Integer.parseInt(parts[4]);
                    Frame frameStatus = Frame.parseFrame(parts[5]);
                    map.changeStatusOfFrameRectangle(xStartFrame, yStartFrame, width, height, frameStatus);
                }
                else if (parts[0].charAt(0) == 'C')
                {
                    int centerX = Integer.parseInt(parts[1]);
                    int centerY = Integer.parseInt(parts[2]);
                    int radius = Integer.parseInt(parts[3]);
                    Frame frameStatus = Frame.parseFrame(parts[4]);
                    map.drawCircle(centerX - 1, centerY - 1, radius, frameStatus);
                }
                line = fileReader.readLine();
            }

            return map;
        }
        catch (IOException e)
        {
            System.out.println("Error during map file reading");
            return null;
        }

    }

    /*-------------------------------QUEST FUNCTIONS---------------------------------------*/
    public static ValidFileRapport isQuestFileValid(String fileLocation)
    {

        ValidFileRapport questFileIsValid = new ValidFileRapport();

        try
        {
            BufferedReader fileTester = new BufferedReader(new FileReader(fileLocation));
            int timer = Integer.parseInt(fileTester.readLine());
            int numberOfQuests = Integer.parseInt(fileTester.readLine());
            int docXLocation = Integer.parseInt(fileTester.readLine());
            int docYLocation = Integer.parseInt(fileTester.readLine());
            String respawnPoints = fileTester.readLine();
            String[] respawnLineParts = respawnPoints.split("\\s");
            int xPosSpy = Integer.parseInt(respawnLineParts[0]);
            int yPosSpy = Integer.parseInt(respawnLineParts[1]);
            int xPosGuard = Integer.parseInt(respawnLineParts[2]);
            int yPosGuard = Integer.parseInt(respawnLineParts[3]);

            if (xPosSpy <= 0)
            {
                questFileIsValid.invalidFilerapport = "posX du point de respawn des Spies inférieur ou égal à 0. Valeur : " + xPosSpy;
                return questFileIsValid;
            }
            if (xPosGuard <= 0)
            {
                questFileIsValid.invalidFilerapport = "posX du point de respawn des Guards inférieur ou égal à 0. Valeur : " + xPosSpy;
                return questFileIsValid;
            }
            if (yPosSpy <= 0)
            {
                questFileIsValid.invalidFilerapport = "posY du point de respawn des Spies inférieur ou égal à 0. Valeur : " + xPosSpy;
                return questFileIsValid;
            }
            if (yPosGuard <= 0)
            {
                questFileIsValid.invalidFilerapport = "posY du point de respawn des Guards inférieur ou égal à 0. Valeur : " + xPosSpy;
                return questFileIsValid;
            }

            if (docXLocation < 0 || docYLocation < 0)
            {
                questFileIsValid.invalidFilerapport = "doc hors de la map";
                return questFileIsValid;
            }
            else
            {
                if (0 >= numberOfQuests)
                {
                    questFileIsValid.invalidFilerapport = "invalid number of quests";
                    return questFileIsValid;
                }
                else
                {
                    int index = 0;
                    String line = fileTester.readLine();

                    while ((line != null) && (!"".equals(line)))
                    {

                        String[] parts = line.split("\\s");
                        if (Integer.parseInt(parts[0]) < 0)
                        {
                            questFileIsValid.invalidFilerapport = "error at first param, quest " + index;
                            return questFileIsValid;
                        }
                        if (Integer.parseInt(parts[1]) < 0)
                        {
                            questFileIsValid.invalidFilerapport = "error at second param, quest " + index;
                            return questFileIsValid;
                        }
                        if (Integer.parseInt(parts[2]) < 0)
                        {
                            questFileIsValid.invalidFilerapport = "error at third param, quest " + index;
                            return questFileIsValid;
                        }
                        if (Integer.parseInt(parts[3]) < 0)
                        {
                            questFileIsValid.invalidFilerapport = "error at fourth param, quest " + index;
                            return questFileIsValid;
                        }

                        line = fileTester.readLine();
                        index++;
                    }
                    if (numberOfQuests != index)
                    {
                        questFileIsValid.invalidFilerapport = "incorrect number of quests";
                        return questFileIsValid;
                    }
                    else
                    {
                        questFileIsValid.fileIsValid = true;
                        questFileIsValid.invalidFilerapport = "valid file";
                        return questFileIsValid;
                    }
                }
            }
        }
        catch (IOException e)
        {
            questFileIsValid.invalidFilerapport = "error during quest file read";
            return questFileIsValid;
        }

    }

    public static GameMode loadQuestsFromFile(String fileLocation)
    {

        try
        {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileLocation));
            GameMode gameMode = new GameMode();
            gameMode.setTimer(Integer.parseInt(fileReader.readLine()));
            gameMode.setNumberOfQuests(Integer.parseInt(fileReader.readLine()));
            String docXLocationText = fileReader.readLine();
            String QuestYlocationText = fileReader.readLine();
            gameMode.setDoc(Integer.parseInt(docXLocationText), Integer.parseInt(QuestYlocationText));
            String respawnPoints = fileReader.readLine();
            String[] StringParts = respawnPoints.split("\\s");
            int spyRespawnPosX = Integer.parseInt(StringParts[0]);
            int spyRespawnPosY = Integer.parseInt(StringParts[1]);
            int guardRespawnPosX = Integer.parseInt(StringParts[2]);
            int guardRespawnPosY = Integer.parseInt(StringParts[3]);
            gameMode.setSpiesRespawnPoint(spyRespawnPosX, spyRespawnPosY);
            gameMode.setGuardsRespawnPoint(guardRespawnPosX, guardRespawnPosY);

            String line = fileReader.readLine();
            int index = 0;

            while ((line != null) && (!"".equals(line)))
            {

                String[] parts = line.split("\\s");
                int posX = Integer.parseInt(parts[0]);
                int posY = Integer.parseInt(parts[1]);
                int PriceWon = Integer.parseInt(parts[2]);
                int TeamPriceWon = Integer.parseInt(parts[3]);
                gameMode.setQuests(posX, posY, false, index, PriceWon, TeamPriceWon);

                line = fileReader.readLine();
                index++;
            }

            return gameMode;

        }
        catch (IOException e)
        {
            System.out.println("quest file load fail");
            return null;
        }
    }

}
