package gamedatas;

/**
 * This is the "Map" class, made to represent a map in the game engine.
 *
 * @author WOERLY-MOUSSIER Joachim <joachim.woerly-moussier@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public class Map
{

    /* ---------------------- START DECLARATIONS ---------------------- */
    /**
     * the number of columns of the current map.
     */
    public int numberOfColumns;

    /**
     * the numer of lines of the current map.
     */
    public int numberOfLines;

    /**
     * the current map (an array of Frames).
     */
    public Frame[][] map;

    
    public static final int STANDARD_X_SIZE_VALUE = 1000;
    
    public static final int STANDARD_Y_SIZE_VALUE = 1000;
    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    /**
     * Constructor of a Map. Creates a map initialized with walls in all of its
     * Frames. Maximum size is 13300*13300.
     *
     * @param numberOfColumns the number of columns of the map.
     * @param numberOfLines the number of lines of the map.
     */
    public Map(int numberOfColumns, int numberOfLines)
    {
        this.numberOfColumns = numberOfColumns;
        this.numberOfLines = numberOfLines;
        this.map = new Frame[this.numberOfColumns][this.numberOfLines];
        for (int lineToDealWith = 0; lineToDealWith < this.numberOfLines; lineToDealWith++) {
            for (int columnToDealWith = 0; columnToDealWith < this.numberOfColumns; columnToDealWith++) {
                this.map[columnToDealWith][lineToDealWith] = Frame.WALL;
            }
        }

    }

    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    /**
     * Function used to change the status of the frames within a rectangle.
     *
     * @param xStartCase the abciss of the left border of the rectangle
     * @param yStartCase the number of the top row of the rectangle
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     * @param frameStatus the frame status that is to be inserted into the
     * frames within the rectangle
     */
    public void changeStatusOfFrameRectangle(int xStartCase, int yStartCase, int width, int height, Frame frameStatus)
    {
        for (int lineToDealWith = yStartCase - 1; lineToDealWith < (yStartCase + height - 1); lineToDealWith++) {
            for (int columnToDealWith = xStartCase - 1; columnToDealWith < (xStartCase + width - 1); columnToDealWith++) {
                this.map[columnToDealWith][lineToDealWith] = frameStatus;
            }
        }
    }

    @Override
    public String toString()
    {
        String stringDescriptionOfMap = "";

        for (int lineToDealWith = 0; lineToDealWith < this.numberOfLines; lineToDealWith++) {
            for (int columnToDealWith = 0; columnToDealWith < this.numberOfColumns; columnToDealWith++) {
                stringDescriptionOfMap += this.map[columnToDealWith][lineToDealWith];
            }
            stringDescriptionOfMap += "\n";
        }
        return stringDescriptionOfMap;

    }
    /* ---------------------- END FUNCTION(S) ---------------------- */
}
