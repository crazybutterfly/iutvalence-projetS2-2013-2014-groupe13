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

    /**
     * Argent mis à disposition du Guard Chief.
     */
    private final Coins guardCoins;

    /**
     * Tableau de caméras utilisable par le Guard Chief.
     */
    private final Cam[] cams;

    /**
     * Nombre de caméra du Guard Chief.
     */
    private int numberOfCams;

    /**
     * Pseudo par défaut du Guard Chief.
     */
    public final static String DEFAULT_PSEUDO_FOR_GUARD_CHIEF = "_GUARD_BIG_BOSS";

    /**
     * Nombre de caméra par défaut du Guard Chief.
     */
    public final static int NUMBER_OF_CAMS_DEFAULT = 3;

    /**
     * Nombre de caméra maximum utilisable par le Guard Chief.
     */
    public final static int NUMBER_OF_CAMS_MAXIMUM = 10;

    //public [WHATTYPE ?]camsView;
    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public GuardChiefPlayer()
    {
        super();
        this.pseudo += DEFAULT_PSEUDO_FOR_GUARD_CHIEF;
        this.guardCoins = new Coins();
        this.numberOfCams = NUMBER_OF_CAMS_DEFAULT;
        this.cams = new Cam[NUMBER_OF_CAMS_MAXIMUM];
        for (int i = 0; i < NUMBER_OF_CAMS_MAXIMUM - 1; i++) {
            this.cams[i] = new Cam(i++);
        }
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */


}
