package utils;

import gamedatas.Frame;
import gamedatas.Map;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
    public GameInformationLoaderFromFile() {

    }

    /**
     * Creates a map from the file read.
     *
     * @param fileLocation
     * @return a map.
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     */
    public Map loadMapFromFile(String fileLocation) throws IOException, FileNotFoundException {
        this.fileReader = new BufferedReader(new FileReader(fileLocation));
        int mapXSize;
        int mapYSize;
        try {
            String mapXSizeText = this.fileReader.readLine();
            if (mapXSizeText == null) {
                mapXSize = Map.STANDARD_X_SIZE_VALUE;
            } else {
                mapXSize = Integer.parseInt(mapXSizeText);
            }

            String mapYSizeText = this.fileReader.readLine();
            if (mapYSizeText == null) {
                mapYSize = Map.STANDARD_Y_SIZE_VALUE;
            } else {
                mapYSize = Integer.parseInt(mapYSizeText);
            }

        } catch (IOException e) {
            System.out.println("Erreur");
            return null;
        }
        Map map = new Map(mapXSize, mapYSize);

        try {
            String line = fileReader.readLine();

            while ((line != null) && (!"".equals(line))) {

                String[] parts = line.split("\\s");
                int xStartFrame = Integer.parseInt(parts[0]);
                int yStartFrame = Integer.parseInt(parts[1]);
                int width = Integer.parseInt(parts[2]);
                int height = Integer.parseInt(parts[3]);
                Frame frameStatus = Frame.parseFrame(parts[4]);
                map.changeStatusOfFrameRectangle(xStartFrame, yStartFrame, width, height, frameStatus);
                line = fileReader.readLine();
            }

        } catch (IOException e) {
            System.out.println("Erreur dans le fichier");
            return null;
        }
        return map;
    }

}


