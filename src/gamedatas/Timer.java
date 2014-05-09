package gamedatas;

/**
 * Class used to store time game informations.
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public class Timer
{

    /* ---------------------- START DECLARATIONS ---------------------- */
    /**
     * maximum time for a game.
     */
    private int maxGameTime;

    /**
     * Time since the game has start.
     */
    private long startGameTime;

    /**
     * the default maximum time for a game in minutes.
     */
    public static final int MAX_GAME_TIME_DEFAULT = 30;

    /**
     * the initial game time.
     */
    public static final int START_GAME_TIME = 0;
    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public Timer()
    {
        this.maxGameTime = Timer.MAX_GAME_TIME_DEFAULT;
        this.startGameTime = Timer.START_GAME_TIME;
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /**
     * start the timer of a game.
     */
    public void StartTimer()
    {
        this.startGameTime = System.currentTimeMillis();
    }

    /**
     * calculate time spent in milliseconds from the start of the game.
     *
     * @return the time spent in milliseconds from the start of the game
     */
    private long getTimeSpentInGameInMilliSeconds()
    {
        return System.currentTimeMillis() - this.startGameTime;
    }
    /* ---------------------- START FUNCTION(S) ---------------------- */

    /* ---------------------- END GETTERS AND SETTERS ---------------------- */
    /**
     * @return the maxGameTime
     */
    public int getMaxGameTime()
    {
        return maxGameTime;
    }

    /**
     * @param maxGameTime the maxGameTime to set
     */
    public void setMaxGameTime(int maxGameTime)
    {
        this.maxGameTime = maxGameTime;
    }

}
