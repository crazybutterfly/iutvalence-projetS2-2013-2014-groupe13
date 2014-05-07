package gamedatas;

/**
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author DUBOIS Thomas <thomas.dubois@iut-valence.fr>
 */
public class GuardPlayer extends ClassicPlayer
{
    /* ---------------------- START DECLARATIONS ---------------------- */

    private int timeToRespawn;
    private Stats stats;
    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    public GuardPlayer()
    {
        super();
    }

    public void useGun(ClassicPlayer classicPlayers)
    {
    }

    public void guardPlayer()
    {
        this.stats = stats;
    }

    /**
     * function to increment the waiting_for_respawn time.
     *
     * @param time how much time we add the the waiting_for_respawn timer.
     */
    public void incrementTimeToRespawn(int time)
    {
        this.timeToRespawn += time;
    }
    /* ---------------------- END FUNCTION(S) ---------------------- */
}
