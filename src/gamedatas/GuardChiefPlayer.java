package gamedatas;

import items.Cam;

/**
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author DUBOIS Thomas <thomas.dubois@iut-valence.fr>
 */
public class GuardChiefPlayer extends Player {

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
    public GuardChiefPlayer(Map refToMap, AllPlayers refToPlayers)
    {
        super(refToMap, refToPlayers);
        this.pseudo += GuardChiefPlayer.DEFAULT_PSEUDO_FOR_GUARD_CHIEF;
        this.guardCoins = new Coins();
        this.numberOfCams = GuardChiefPlayer.NUMBER_OF_CAMS_DEFAULT;
        this.cams = new Cam[GuardChiefPlayer.NUMBER_OF_CAMS_MAXIMUM];
        for (int i = 0; i < GuardChiefPlayer.NUMBER_OF_CAMS_MAXIMUM - 1; i++)
        {
            this.cams[i] = new Cam(i + 1, 0, 0);
        }
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    /**
     * @return the guardCoins
     */
    public Coins getGuardCoins()
    {
        return guardCoins;
    }
    /* ---------------------- END GETTERS AND SETTERS ---------------------- */

}
