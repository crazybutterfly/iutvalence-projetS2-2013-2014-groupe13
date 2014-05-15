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

    /**
     * Argent du Spy.
     */
    private Coins myCoins;

    /**
     * Temps de réapparition du Spy.
     */
    private int timeToRespawn;

    /**
     * Stats du Spy.
     */
    protected SpyStats stats;

    /**
     * Pseudo par défaut du Spy.
     */
    public final static String DEFAULT_PSEUDO_PREFIX_FOR_SPY = "_SPY_";


    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    /**
     * Ajoute un numéro au pseudo du Spy. Donne Les stats du Spy.
     *
     * @param NumberOfThePlayer Numéro du Spy.
     */
    public SpyPlayer(int NumberOfThePlayer, Map refToMap)
    {
        super(refToMap);
        this.pseudo += SpyPlayer.DEFAULT_PSEUDO_PREFIX_FOR_SPY;
        this.pseudo += NumberOfThePlayer;
        this.myCoins = new Coins();
        this.stats = new SpyStats();
    }

    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    /**
     * Fonction permettant au Spy de tuer un Guard avec son couteau.
     *
     * @param guardsArray tableau des cibles Guard potentiel du Spy.
     * @param numberOfGuards Cible Guard du Spy.
     */
    public void useKnife(GuardPlayer[] guardsArray, int numberOfGuards)
    {
        for (int i = 0; i < numberOfGuards - 1; i++) {
            if (guardsArray[i].getPosX() == this.posX && guardsArray[i].getPosY() == this.posY) {
                guardsArray[i].playerHasBeenKilled();
            }
        }
    }

    /* ---------------------- END FUNCTION(S) ---------------------- */

    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    @Override
    public SpyStats getStats()
    {
        return this.stats;
    }


    /* ---------------------- END GETTERS AND SETTERS ---------------------- */
    /**
     * @return the myCoins
     */
    public Coins getMyCoins()
    {
        return myCoins;
    }


}
