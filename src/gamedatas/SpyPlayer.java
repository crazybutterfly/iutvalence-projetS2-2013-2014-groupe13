package gamedatas;

import items.Knife;

/**
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author DUBOIS Thomas <thomas.dubois@iut-valence.fr>
 */
public class SpyPlayer extends ClassicPlayer {
    /* ---------------------- START DECLARATIONS ---------------------- */

    /**
     * Argent du Spy.
     */
    private Coins myCoins;

    /**
     * Stats du Spy.
     */
    protected SpyStats stats;

    /**
     * Pseudo par défaut du Spy.
     */
    public final static String DEFAULT_PSEUDO_PREFIX_FOR_SPY = "_SPY_";

    /**
     * Temps à ajouter pour le prochain respawn.
     */
    public final static int SPY_TIME_TO_INCREMENT_FOR_RESAWN_TIME = 5;


    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    /**
     * Ajoute un numéro au pseudo du Spy. Donne Les stats du Spy.
     *
     * @param NumberOfThePlayer Numéro du Spy.
     */
    public SpyPlayer(int NumberOfThePlayer, Map refToMap, AllPlayers refToPlayers, GameMode refToGameMode)
    {
        super(refToMap, refToPlayers);
        this.pseudo += SpyPlayer.DEFAULT_PSEUDO_PREFIX_FOR_SPY;
        this.pseudo += NumberOfThePlayer;
        this.myCoins = new Coins();
        this.stats = new SpyStats();
        this.currentMoves = new SpyPlayerMoves(this);
        this.posX = refToGameMode.getSpyRespawnPointPosX();
        this.posY = refToGameMode.getSpyRespawnPointPosY();
        this.items[0] = new Knife();
    }

    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */
    @Override
    public void playerHasBeenKilled()
    {
        this.stats.decrementRemainingLives();
        if (this.stats.getRemainingLives() == 0)
        {
            this.currentStatus = PlayerStatus.DEAD;
        }
        else
        {
            this.currentStatus = PlayerStatus.WAITING_FOR_RESPAWN;
            this.respawnTime = (this.nextTimeBeforeRespawn * 1000) + System.currentTimeMillis();
            this.nextTimeBeforeRespawn += SpyPlayer.SPY_TIME_TO_INCREMENT_FOR_RESAWN_TIME;
            this.currentStatus = PlayerStatus.WAITING_FOR_RESPAWN;
        }
    }


    @Override
    public void refeshKilledPlayerStatuts()
    {
        if ((System.currentTimeMillis() >= this.respawnTime) && (this.currentStatus == PlayerStatus.WAITING_FOR_RESPAWN))
        {
            this.currentStatus = PlayerStatus.ALIVE;
            this.updatePosition(this.getPlayerArray().getGameMode().getSpyRespawnPointPosX(), this.getPlayerArray().getGameMode().getSpyRespawnPointPosY());
        }
    }
    /* ---------------------- START FUNCTION(S) ---------------------- */


    /* ---------------------- END FUNCTION(S) ---------------------- */

    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    @Override
    public SpyStats getStats()
    {
        return this.stats;
    }

    /**
     * @return the myCoins
     */
    public Coins getMyCoins()
    {
        return myCoins;
    }


    /* ---------------------- END GETTERS AND SETTERS ---------------------- */
}
