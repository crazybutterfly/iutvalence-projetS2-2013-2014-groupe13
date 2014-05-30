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

    /**
     * Temps à ajouter pour le prochain respawn.
     */
    public final static int GUARD_TIME_TO_INCREMENT_FOR_RESAWN_TIME = 15;

    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    /**
     * Ajoute un numéro au pseudo par défaut du Guard. Donne les stats du Guard.
     *
     * @param NumberOfThePlayer Numéro du Guard.
     * @param refToMap
     * @param refToPlayers
     */
    public GuardPlayer(int NumberOfThePlayer, Map refToMap, AllPlayers refToPlayers)
    {
        super(refToMap, refToPlayers);
        this.pseudo += GuardPlayer.DEFAULT_PSEUDO_PREFIX_FOR_GUARD;
        this.pseudo += NumberOfThePlayer;
        this.stats = new Stats();
        this.currentMoves = new GuardPlayerMoves(this);
    }

    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */
    /* ---------------------- START FUNCTION(S) ---------------------- */

    @Override
    public void playerHasBeenKilled()
    {
        this.respawnTime = (this.nextTimeBeforeRespawn * 1000) + System.currentTimeMillis();
        this.nextTimeBeforeRespawn += GuardPlayer.GUARD_TIME_TO_INCREMENT_FOR_RESAWN_TIME;
        this.currentStatus = PlayerStatus.WAITING_FOR_RESPAWN;
    }
    
       @Override
    public void refeshKilledPlayerStatuts()
    {
         if ((System.currentTimeMillis() >= this.respawnTime) && (this.currentStatus != PlayerStatus.DEAD)) {
            this.currentStatus = PlayerStatus.ALIVE;
            this.updatePosition(this.getPlayerArray().getGameMode().getGuardRespawnPointPosX(),this.getPlayerArray().getGameMode().getGuardRespawnPointPosY());
        }
    }
    /* ---------------------- END FUNCTION(S) ---------------------- */
}
