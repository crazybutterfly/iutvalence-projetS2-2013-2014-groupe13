package utils;

import gamedatas.Frame;
import gamedatas.Map;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

/**
 *
 * @author WOERLY-MOUSSIER Joachim <joachim.woerly-moussier@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public class GameInformationLoaderFromFile
{

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

    /**
     * Creates a map from the file read.
     *
     * @param fileLocation
     *
     * @return a map.
     *
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     */
    public boolean isMapFileValid(String fileLocation) throws IOException, FileNotFoundException
    {
        if (!this.fileExists(fileLocation))
        {
            System.out.println("file not found");
            return false;
        }
        else
        {

            BufferedReader fileTester = new BufferedReader(new FileReader(fileLocation));
            try
            {
                int mapXSizeTest = Integer.parseInt(fileTester.readLine());
                int mapYSizeTest = Integer.parseInt(fileTester.readLine());
                if ((mapXSizeTest > Map.MAX_X_SIZE) || (mapYSizeTest > Map.MAX_Y_SIZE))
                {
                    System.out.println("erreur de dimension de la map");
                    return false;
                }

                String line = fileTester.readLine();
                int index = 3;
                while ((line != null) && (!"".equals(line)))
                {

                    String[] parts = line.split("\\s");
                    if ((parts[0].charAt(0) != 'R') && (parts[0].charAt(0) != 'C'))
                    {
                        System.out.println("erreur R && C ligne " + index);
                        return false;
                    }
                    if (parts[0].charAt(0) == 'R')
                    {
                        if ((Integer.parseInt(parts[1]) > mapXSizeTest) || (Integer.parseInt(parts[1]) < 0))
                        {
                            System.out.println("erreur premier param rectangle ligne " + index);
                            return false;
                        }
                        if ((Integer.parseInt(parts[2]) > mapYSizeTest) || (Integer.parseInt(parts[2]) < 0))
                        {
                            System.out.println("erreur second param rectangle ligne " + index);
                            return false;
                        }
                        if ((Integer.parseInt(parts[3]) > mapXSizeTest) || (Integer.parseInt(parts[3]) < 0))
                        {
                            System.out.println("erreur troisième param rectangle ligne " + index);
                            return false;
                        }
                        if ((Integer.parseInt(parts[4]) > mapYSizeTest) || (Integer.parseInt(parts[4]) < 0))
                        {
                            System.out.println("erreur quatrième param rectangle ligne " + index);
                            return false;
                        }
                        if ((!parts[5].equals("W")) && (!parts[5].equals("F")) && (!parts[5].equals("S")) && (!parts[5].equals("G")))
                        {
                            System.out.println("erreur format case ligne " + index);
                            return false;
                        }
                    }
                    else if (parts[0].charAt(0) == 'C')
                    {
                        if ((Integer.parseInt(parts[1]) <= Integer.parseInt(parts[3])) || (Integer.parseInt(parts[1]) >= mapXSizeTest - Integer.parseInt(parts[3])))
                        {
                            System.out.println("erreur premier param cercle ligne " + index);
                            return false;
                        }
                        if ((Integer.parseInt(parts[2]) <= Integer.parseInt(parts[3])) || (Integer.parseInt(parts[2]) >= mapXSizeTest - Integer.parseInt(parts[3])))
                        {
                            System.out.println("erreur second param cercle ligne " + index);
                            return false;
                        }
                        if ((!parts[4].equals("W")) && (!parts[4].equals("F")) && (!parts[4].equals("S")) && (!parts[4].equals("G")))
                        {
                            System.out.println("erreur format case ligne " + index);
                            return false;
                        }
                    }

                    line = fileTester.readLine();
                }
            }
            catch (IOException e)
            {
                System.out.println("fichier invalide");
                return false;
            }
            System.out.println("Fichier valide");
            return true;
        }
    }

    public boolean fileExists(String fileLocation) throws FileNotFoundException
    {
        File file = new File(fileLocation);
        return file.exists();
    }

    public Map loadMapFromFile(String fileLocation) throws IOException, FileNotFoundException
    {
        this.fileReader = new BufferedReader(new FileReader(fileLocation));
        int mapXSize;
        int mapYSize;
        try
        {
            String mapXSizeText = this.fileReader.readLine();
            if (mapXSizeText == null)
            {
                mapXSize = Map.STANDARD_X_SIZE_VALUE;
            }
            else
            {
                mapXSize = Integer.parseInt(mapXSizeText);
            }

            String mapYSizeText = this.fileReader.readLine();
            if (mapYSizeText == null)
            {
                mapYSize = Map.STANDARD_Y_SIZE_VALUE;
            }
            else
            {
                mapYSize = Integer.parseInt(mapYSizeText);
            }

        }
        catch (IOException e)
        {
            System.out.println("Erreur");
            return null;
        }
        Map map = new Map(mapXSize, mapYSize);

        try
        {
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

        }
        catch (IOException e)
        {
            System.out.println("Erreur dans le fichier");
            return null;
        }
        return map;
    }

}
