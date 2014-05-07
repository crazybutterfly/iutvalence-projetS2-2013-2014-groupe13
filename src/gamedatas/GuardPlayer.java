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

    /**
     * Temps d'attente avant réapparition après mort du Guard.
     */
    private int timeToRespawn;
    
    /**
     * Nom par défaut du Guard.
     */
    public final static String DEFAULT_PSEUDO_PREFIX_FOR_GUARD = "_GUARD_";
    /* ---------------------- END DECLARATIONS ---------------------- */
    
    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    
    /**
     * Ajoute un numéro au pseudo par défaut du Guard.
     * Donne les stats du Guard.
     * @param NumberOfThePlayer Numéro du Guard.
     */
    public GuardPlayer(int NumberOfThePlayer)
    {
        super();
        this.pseudo += DEFAULT_PSEUDO_PREFIX_FOR_GUARD;
        this.pseudo += NumberOfThePlayer;
        this.stats = new Stats();
    }
    
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */
    

    /* ---------------------- START FUNCTION(S) ---------------------- */

    /**
     * Fonction permettant à un Guard d'utiliser un pistolet.
     * @param classicPlayers 
     */
    public void useGun(ClassicPlayer classicPlayers)
    {
    }

    /**
     * Fonction permettant à un Guard de voir ses stats de partie.
     */
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
