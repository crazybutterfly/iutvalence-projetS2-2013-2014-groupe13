package gamedatas;

/**
 * Class which store coins for a player.
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author DUBOIS Thomas <thomas.dubois@iut-valence.fr>
 */
public class Coins
{
    /* ---------------------- START DECLARATIONS ---------------------- */

    private int quantity;

    /* ---------------------- END DECLARATIONS ---------------------- */
    /**
     * a procedure to add coins
     *
     * @param quantity how many coins we add
     * @return 
     */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    public boolean changeCoinQuantity(int quantity)
    {
            if (this.quantity + quantity < 0) return false;
            this.quantity += quantity;
            return true;
    }

    /* ---------------------- END FUNCTION(S) ---------------------- */
}
