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
     */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    public void addingCoin(int quantity)
    {
        this.quantity += quantity;
    }

    /**
     * a procedure to remove coins
     *
     * @param quantity how many coins we remove
     */
    public void removeCoin(int quantity)
    {
        this.quantity -= quantity;
    }
    /* ---------------------- END FUNCTION(S) ---------------------- */
}
