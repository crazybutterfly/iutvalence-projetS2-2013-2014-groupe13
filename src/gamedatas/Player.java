package gamedatas;

/**
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author DUBOIS Thomas <thomas.dubois@iut-valence.fr>
 */
public class Player
{
    /* ---------------------- START DECLARATIONS ---------------------- */

    public String pseudo;
    
    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    public void Player()
    {
    }

    private Stats stats;

    public Stats getStats()
    {
        return this.stats;
    }
    /* ---------------------- END FUNCTION(S) ---------------------- */
}