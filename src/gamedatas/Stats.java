package gamedatas;

/**
 *
 * @author begotw
 */
public class Stats
{


    /* ---------------------- START DECLARATIONS ---------------------- */
    protected int numberOfKills;
    protected int numberOfDeaths;

    public static final int NUMBER_OF_KILLS_DEFAULT = 0;
    public static final int NUMBER_OF_DEATH_DEFAULT = 0;
    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public Stats()
    {
        this.numberOfKills = NUMBER_OF_KILLS_DEFAULT;
        this.numberOfDeaths = NUMBER_OF_DEATH_DEFAULT;
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */


    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    /**
     * @return the numberOfKills
     */
    public int getNumberOfKills()
    {
        return numberOfKills;
    }

    /**
     * @param numberOfKills the numberOfKills to set
     */
    public void setNumberOfKills(int numberOfKills)
    {
        this.numberOfKills = numberOfKills;
    }

    /**
     * @return the numberOfDeaths
     */
    public int getNumberOfDeaths()
    {
        return numberOfDeaths;
    }

    /**
     * @param numberOfDeaths the numberOfDeaths to set
     */
    public void setNumberOfDeaths(int numberOfDeaths)
    {
        this.numberOfDeaths = numberOfDeaths;
    }
    /* ---------------------- END GETTERS AND SETTERS ---------------------- */
}
