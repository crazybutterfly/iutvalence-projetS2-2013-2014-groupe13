package gamedatas;

import items.Item;

/**
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author DUBOIS Thomas <thomas.dubois@iut-valence.fr>
 */
public class ClassicPlayer extends Player
{

    /* ---------------------- START DECLARATIONS ---------------------- */

    /**
     * Position en x du joueur.
     */
    protected int posX;

    /**
     * Position en y du joueur.
     */
    protected int posY;

    /**
     * Statut actuel du joueur.
     */
    protected PlayerStatus currentStatus;

    /**
     * Dernier temps d'attente de réapparition du joueur.
     */
    protected int lastTimeBeforeRespawn;

    /**
     * Temps restant avant réapparition du joueur.
     */
    protected int remainingTimeBeforeRespawn;

    /**
     * Nombre de vie initial du joueur.
     */
    protected int initialNumberOfLives;

    /**
     * Tableau recensant les type items du joueur.
     */
    protected Item[] items;

    /**
     * Tableau recensant le nombre d'item par type d'item.
     */
    protected int[] numberOfItemsByType;

    /**
     * Nombre de type d'item possédé pour savoir le nombre de case utilisé du
     * tableau items.
     */
    protected int currentNumberOfItemTypePocessed;

    /**
     * Statistique du joueur.
     */
    protected Stats stats;

    /**
     * Valeur par défaut de la position X.
     */
    public final static int POS_X_DEFAULT = 0;

    /**
     * Valeur par défaut de la position Y.
     */
    public final static int POS_Y_DEFAULT = 0;

    /**
     * Statut actuel du joueur par défaut. Ici le joueur est en vie.
     */
    public final static PlayerStatus CURRENT_STATUTS_DEFAULT = PlayerStatus.ALIVE;

    /**
     * Dernier temps d'attente de réapparition du joueur par défaut. Ici il est
     * de 0.
     */
    public final static int LAST_TIME_BEFORE_RESPAWN_DEFAULT = 0;

    /**
     * Temps d'attente du joueur avant réapparition par défaut. Ici il est de 0.
     */
    public final static int REMAINING_TIME_BEFORE_RESPAWN_DEFAULT = 0;

    /**
     * Nombre de vie initial du joueur. Ici, elle ne sont pas encore définies
     * donc les joueurs n'en ont pas.
     */
    public final static int INITIAL_NUMBER_OF_LIVES = 0;

    /**
     * Nombre maximum d'item transportable par le joueur. Le joueur ne pourra
     * porter que 10 items au maximum.
     */
    public final static int MAXIMUM_NUMBER_OF_ITEM_TYPE = 10;

   /**
     * Nombre d'item que le joueur possède par type d'item.
     * Il possède un item du type d'item de base : couteau ou pistolet selon si c'est un Guard ou un Spie.
     */
    public final static int NUMBER_OF_ITEM_POCESSED_BY_TYPE_DEFAULT = 1;

    /**
     * Nombre de type d'item que le joueur possède en début de partie. Le joueur
     * possède un item. Si c'est un Spies, c'est un couteau et si c'est un
     * Guard, c'est un pistolet.
     */
    public final static int CURRENT_NUMBER_OF_ITEM_TYPE_POCESSED_DEFAULT = 1;
    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public ClassicPlayer()
    {
        super();
        this.posX = POS_X_DEFAULT;
        this.posY = POS_Y_DEFAULT;
        this.currentStatus = CURRENT_STATUTS_DEFAULT;
        this.lastTimeBeforeRespawn = LAST_TIME_BEFORE_RESPAWN_DEFAULT;
        this.remainingTimeBeforeRespawn = REMAINING_TIME_BEFORE_RESPAWN_DEFAULT;
        this.initialNumberOfLives = INITIAL_NUMBER_OF_LIVES;
        this.items = new Item[MAXIMUM_NUMBER_OF_ITEM_TYPE];
        for (int i = 0; i < MAXIMUM_NUMBER_OF_ITEM_TYPE; i++) {
            this.items[i] = new Item();
        }
        this.numberOfItemsByType = new int[MAXIMUM_NUMBER_OF_ITEM_TYPE];
        for (int i = 0; i < MAXIMUM_NUMBER_OF_ITEM_TYPE; i++) {
            this.numberOfItemsByType[i] = NUMBER_OF_ITEM_POCESSED_BY_TYPE_DEFAULT;
        }
        this.currentNumberOfItemTypePocessed = CURRENT_NUMBER_OF_ITEM_TYPE_POCESSED_DEFAULT;
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */
    /* ---------------------- START FUNCTION(S) ---------------------- */

    /**
     * Fonction mettant à jour la position(X,Y) du joueur.
     * @param newPosX Position X.
     * @param newPosY Position Y.
     */
    public void updatePosition(int newPosX, int newPosY)
    {
        this.posX = newPosX;
        this.posY = newPosY;
    }

    /**
     * Fonction attribuant au joueur le statut "en attente de réapparition".
     * Fonction qui retirera un Spies en cas de mort définitive... à voir avec autre fonction ?
     * Fonction qui lors de la mort d'un Guard, ajoute un malus de temps de réapparition. Plus le Guard meurt plus le temps de réapparition augmente... à voir avec autre fonction ?
     */
    public void playerHasBeenKilled()
    {

    }
    /* ---------------------- END FUNCTION(S) ---------------------- */
    
    /* ---------------------- START GETTERS & SETTERS ---------------------- */

    public Stats getStats()
    {
        return this.stats;
    }


    /**
     * @return the posX
     */
    public int getPosX()
    {
        return posX;
    }

    /**
     * @return the posY
     */
    public int getPosY()
    {
        return posY;
    }

    /**
     * @return the currentStatus
     */
    public PlayerStatus getCurrentStatus()
    {
        return currentStatus;
    }

    /**
     * @param currentStatus the currentStatus to set
     */
    public void setCurrentStatus(PlayerStatus currentStatus)
    {
        this.currentStatus = currentStatus;
    }

    /**
     * @return the remainingTimeBeforeRespawn
     */
    public int getRemainingTimeBeforeRespawn()
    {
        return remainingTimeBeforeRespawn;
    }

    /**
     * @param remainingTimeBeforeRespawn the remainingTimeBeforeRespawn to set
     */
    public void setRemainingTimeBeforeRespawn(int remainingTimeBeforeRespawn)
    {
        this.remainingTimeBeforeRespawn = remainingTimeBeforeRespawn;
    }
    /* ---------------------- END GETTERS AND SETTERS ---------------------- */
}
