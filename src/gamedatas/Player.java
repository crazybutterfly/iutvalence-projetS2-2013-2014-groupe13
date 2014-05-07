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

    /**
     * Attribut attribuant un pseudo à un joueur.
     */
    protected String pseudo;

    /**
     * Pseudo par défaut d'un joueur.
     */
    public final static String DEFAULT_PSEUDO_PREFIX = "PLAYER";
    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public Player()
    {
        this.pseudo = DEFAULT_PSEUDO_PREFIX;
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */


}
