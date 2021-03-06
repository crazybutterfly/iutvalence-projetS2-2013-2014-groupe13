package gamedatas;

import items.Doc;
import items.EmptyItem;
import items.Item;

/**
 * This is the "Map" class, made to represent a map in the game engine.
 *
 * @author WOERLY-MOUSSIER Joachim <joachim.woerly-moussier@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public class Map {

    /* ---------------------- START DECLARATIONS ---------------------- */
    /**
     * the maximum lateral size of the map.
     */
    public static final int MAX_X_SIZE = 13330;

    /**
     * the maximum vertical size of the map.
     */
    public static final int MAX_Y_SIZE = 13330;

    /**
     * the number of columns of the current map.
     */
    private final int numberOfColumns;

    /**
     * the number of lines of the current map.
     */
    private final int numberOfLines;

    /**
     * the current map (an array of Frames).
     */
    private final Frame[][] map;

    /**
     * items put on the map.
     */
    private Item[] itemsOnTheMap = new Item[10000];

    private int numberOfItemsOnTheMap;

    public static final int STANDARD_X_SIZE_VALUE = 1000;

    public static final int STANDARD_Y_SIZE_VALUE = 1000;
    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    /**
     * Constructor of a Map. Creates a map initialized with walls in all of its
     * Frames. Maximum size is 13300*13300.
     *
     * @param numberOfColumns the number of columns of the map.
     * @param numberOfLines   the number of lines of the map.
     */
    public Map(int numberOfColumns, int numberOfLines)
    {
        this.numberOfColumns = numberOfColumns;
        this.numberOfLines = numberOfLines;
        this.map = new Frame[this.numberOfColumns][this.numberOfLines];
        for (int lineToDealWith = 0; lineToDealWith < this.numberOfLines; lineToDealWith++)
        {
            for (int columnToDealWith = 0; columnToDealWith < this.numberOfColumns; columnToDealWith++)
            {
                this.map[columnToDealWith][lineToDealWith] = Frame.WALL;
            }
        }
        for (int i = 0; i < 10000; i++)
        {
            this.itemsOnTheMap[i] = new EmptyItem();
        }
        this.itemsOnTheMap[0] = new Doc(0, 0);
        this.numberOfItemsOnTheMap = 1;
    }

    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    /**
     * Function used to change the status of the frames within a rectangle.
     *
     * @param xStartCase  the abciss of the left border of the rectangle
     * @param yStartCase  the number of the top row of the rectangle
     * @param width       the width of the rectangle
     * @param height      the height of the rectangle
     * @param frameStatus the frame status that is to be inserted into the
     *                    frames within the rectangle
     */
    public void changeStatusOfFrameRectangle(int xStartCase, int yStartCase, int width, int height, Frame frameStatus)
    {
        for (int lineToDealWith = yStartCase - 1; lineToDealWith < (yStartCase + height - 1); lineToDealWith++)
        {
            for (int columnToDealWith = xStartCase - 1; columnToDealWith < (xStartCase + width - 1); columnToDealWith++)
            {
                this.map[columnToDealWith][lineToDealWith] = frameStatus;
            }
        }
    }

    /**
     *
     * @param xFrame
     * @param yFrame
     * @param frame
     */
    public void changeStatusOfFrame(int xFrame, int yFrame, Frame frame)
    {
        this.map[xFrame][yFrame] = frame;
    }

    /**
     *
     * @param centerX
     * @param centerY
     * @param radius
     * @param frame
     */
    public void drawCircle(final int centerX, final int centerY, final int radius, final Frame frame)
    {

        for (int i = 0; i < radius; i++)
        {
            int d = 3 - (2 * radius);
            int x = 0;
            int y = radius - i;
            Frame circleFrame = frame;

            do
            {
                this.changeStatusOfFrame(centerX + x, centerY + y, circleFrame);
                this.changeStatusOfFrame(centerX + x, centerY + y - 1, circleFrame);
                this.changeStatusOfFrame(centerX + x, centerY - y, circleFrame);
                this.changeStatusOfFrame(centerX + x, centerY - y + 1, circleFrame);
                this.changeStatusOfFrame(centerX - x, centerY + y, circleFrame);
                this.changeStatusOfFrame(centerX - x, centerY + y - 1, circleFrame);
                this.changeStatusOfFrame(centerX - x, centerY - y, circleFrame);
                this.changeStatusOfFrame(centerX - x, centerY - y + 1, circleFrame);
                this.changeStatusOfFrame(centerX + y, centerY + x, circleFrame);
                this.changeStatusOfFrame(centerX + y - 1, centerY + x, circleFrame);
                this.changeStatusOfFrame(centerX + y, centerY - x, circleFrame);
                this.changeStatusOfFrame(centerX + y - 1, centerY - x, circleFrame);
                this.changeStatusOfFrame(centerX - y, centerY + x, circleFrame);
                this.changeStatusOfFrame(centerX - y + 1, centerY + x, circleFrame);
                this.changeStatusOfFrame(centerX - y, centerY - x, circleFrame);
                this.changeStatusOfFrame(centerX - y + 1, centerY - x, circleFrame);
                if (d < 0)
                {
                    d = d + (4 * x) + 6;
                }
                else
                {
                    d = d + 4 * (x - y) + 10;
                    y--;
                }
                x++;
            }
            while (x <= y);
        }
    }

    @Override
    public String toString()
    {
        String stringDescriptionOfMap = "";

        for (int lineToDealWith = 0; lineToDealWith < this.numberOfLines; lineToDealWith++)
        {
            for (int columnToDealWith = 0; columnToDealWith < this.numberOfColumns; columnToDealWith++)
            {
                stringDescriptionOfMap += this.map[columnToDealWith][lineToDealWith];
            }
            stringDescriptionOfMap += "\n";
        }
        return stringDescriptionOfMap;
    }

    public void addItemOnTheMap(Item itemToAdd)
    {
        this.itemsOnTheMap[this.numberOfItemsOnTheMap] = itemToAdd.getNewItem();
        this.numberOfItemsOnTheMap++;
    }

    public Frame getFrameStatus(int posX, int posY)
    {
        return this.map[posX][posY];
    }
    /* ---------------------- END FUNCTION(S) ---------------------- */


    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    public int getNumberOfColumns()
    {
        return numberOfColumns;
    }

    public int getNumberOfLines()
    {
        return numberOfLines;
    }

    public Frame[][] getMap()
    {
        return map;
    }


    /* ---------------------- END GETTERS AND SETTERS ---------------------- */
}
