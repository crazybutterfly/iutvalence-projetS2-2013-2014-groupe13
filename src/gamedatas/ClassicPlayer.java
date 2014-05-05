package gamedatas;

/**
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author DUBOIS Thomas <thomas.dubois@iut-valence.fr>
 */
public class ClassicPlayer extends Player
{

    /* ---------------------- START DECLARATIONS ---------------------- */
    private int posX;

    private int posY;

    private PlayerStatus status;

    public int lastTimeBeforeRespawn;

    private int timeToRespawn;

    public int initialNumberOfLives;

    public items.Item[] items;

    private Stats stats;
    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    public void updatePosition(int newPosX, int newPosY)
    {
        this.posX = newPosX;
        this.posY = newPosY;
    }

    @Override
    public Stats getStats()
    {
        return this.stats;
    }

    public ClassicPlayer()
    {
        super();
    }

    /**
     * @return the posX
     */
    public int getPosX()
    {
        return posX;
    }

    /**
     * @return the posY
     */
    public int getPosY()
    {
        return posY;
    }

    /**
     * @return the status
     */
    public PlayerStatus getStatus()
    {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(PlayerStatus status)
    {
        this.status = status;
    }

    /**
     * @return the timeToRespawn
     */
    public int getTimeToRespawn()
    {
        return timeToRespawn;
    }

    /**
     * @param timeToRespawn the timeToRespawn to set
     */
    public void setTimeToRespawn(int timeToRespawn)
    {
        this.timeToRespawn = timeToRespawn;
    }
    /* ---------------------- END FUNCTION(S) ---------------------- */
}