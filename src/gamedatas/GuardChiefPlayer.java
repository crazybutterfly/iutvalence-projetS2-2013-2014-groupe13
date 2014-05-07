package gamedatas;

import items.Cam;

/**
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author DUBOIS Thomas <thomas.dubois@iut-valence.fr>
 */
public class GuardChiefPlayer extends Player
{

    /* ---------------------- START DECLARATIONS ---------------------- */
    private Coins myCoins;
    private Stats stats;
    private Cam[] cams;
    //public [WHATTYPE ?]camsView;
    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    public void GuardChiefPlayer()
    {
        this.myCoins = myCoins;
        this.stats = stats;
        this.cams = new Cam[10];
    }
    /* ---------------------- END FUNCTION(S) ---------------------- */
}
