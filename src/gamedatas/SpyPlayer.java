package gamedatas;

/**
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author DUBOIS Thomas <thomas.dubois@iut-valence.fr>
 */
public class SpyPlayer extends ClassicPlayer
{
    /* ---------------------- START DECLARATIONS ---------------------- */

    public Coins myCoins;
    private Stats stats;
    private int timeToRespawn;

    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    public void useKnife(ClassicPlayer classicPlayers)
    {
    }

    public void SpyPlayer()
    {
        this.myCoins = myCoins;
        this.stats = stats;
    }

    public void incrementTimeToRespawn(int time)
    {
        this.timeToRespawn = time;
    }
    /* ---------------------- END FUNCTION(S) ---------------------- */
}
