package gamedatas;

import items.EmptyItem;
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
     * Position en x en centième de case de map du joueur.
     */
    protected int posX;

    /**
     * Position en y en centième de case de map du joueur.
     */
    protected int posY;

    /**
     * Mouvements du joueur.
     */
    protected ClassicPlayerMoves currentMoves;

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
     * Nombre de type d'item possédé pour savoir le nombre de case utilisé du
     * tableau items.
     */
    protected int currentNumberOfTypeItemPocessed;

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
     * Nombre d'item que le joueur possède par type d'item. Il possède un item
     * du type d'item de base : couteau ou pistolet selon si c'est un Guard ou
     * un Spie.
     */
    public final static int NUMBER_OF_ITEM_POCESSED_BY_TYPE_DEFAULT = 1;

    /**
     * Nombre de type d'item que le joueur possède en début de partie. Le joueur
     * possède un item. Si c'est un Spies, c'est un couteau et si c'est un
     * Guard, c'est un pistolet.
     */
    public final static int CURRENT_NUMBER_OF_TYPE_ITEM_POCESSED_DEFAULT = 1;

    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public ClassicPlayer()
    {
        super();
        this.currentMoves = new ClassicPlayerMoves();
        this.posX = ClassicPlayer.POS_X_DEFAULT;
        this.posY = ClassicPlayer.POS_Y_DEFAULT;
        this.currentStatus = ClassicPlayer.CURRENT_STATUTS_DEFAULT;
        this.lastTimeBeforeRespawn = ClassicPlayer.LAST_TIME_BEFORE_RESPAWN_DEFAULT;
        this.remainingTimeBeforeRespawn = ClassicPlayer.REMAINING_TIME_BEFORE_RESPAWN_DEFAULT;
        this.initialNumberOfLives = ClassicPlayer.INITIAL_NUMBER_OF_LIVES;
        this.items = new Item[ClassicPlayer.MAXIMUM_NUMBER_OF_ITEM_TYPE];
        for (int i = 0; i < ClassicPlayer.MAXIMUM_NUMBER_OF_ITEM_TYPE; i++) {
            this.items[i] = new EmptyItem();
        }
        this.currentNumberOfTypeItemPocessed = ClassicPlayer.CURRENT_NUMBER_OF_TYPE_ITEM_POCESSED_DEFAULT;
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */
    /* ---------------------- START FUNCTION(S) ---------------------- */

    /**
     * Fonction mettant à jour la position(X,Y) du joueur.
     *
     * @param newPosX New X Position.
     * @param newPosY New Y position.
     */
    public void updatePosition(int newPosX, int newPosY)
    {
        this.posX = newPosX;
        this.posY = newPosY;
    }

    /**
     * Fonction attribuant au joueur le statut "en attente de réapparition".
     * Fonction qui retirera un Spies en cas de mort définitive... à voir avec
     * autre fonction ? Fonction qui lors de la mort d'un Guard, ajoute un malus
     * de temps de réapparition. Plus le Guard meurt plus le temps de
     * réapparition augmente... à voir avec autre fonction ?
     */
    public void playerHasBeenKilled()
    {

    }

    public void removeItem(String itemName)
    {
        int index = 0;
        while (!this.items[index].getItemName().equals(itemName)) {
            index++;
        }
        if (this.items[index].getNumberOfItemsOfThisType()!= 1) {
            this.items[index].setNumberOfItemsOfThisType(this.items[index].getNumberOfItemsOfThisType()-1);
        }
        else {
            this.items[index] = new EmptyItem();
        }
    }
    
    

    /**
     * @return the map case X position.
     */
    public int getPosXCase()
    {
        return posX / 100;
    }

    /**
     * @return the map case Y position.
     */
    public int getPosYCase()
    {
        return posY / 100;
    }

    /* ---------------------- END FUNCTION(S) ---------------------- */

    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    /**
     * @return the posX
     */
    public int getPosX()
    {
        return this.posX;
    }

    /**
     * @return the posY
     */
    public int getPosY()
    {
        return this.posY;
    }

    /**
     * @param posX the posX to set
     */
    public void setPosX(int posX)
    {
        this.posX = posX;
    }

    /**
     * @param posY the posY to set
     */
    public void setPosY(int posY)
    {
        this.posY = posY;
    }

    public Stats getStats()
    {
        return this.stats;
    }


    /**
     * @return the currentStatus
     */
    public PlayerStatus getCurrentStatus()
    {
        return this.currentStatus;
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
        return this.remainingTimeBeforeRespawn;
    }

    /**
     * @param remainingTimeBeforeRespawn the remainingTimeBeforeRespawn to set
     */
    public void setRemainingTimeBeforeRespawn(int remainingTimeBeforeRespawn)
    {
        this.remainingTimeBeforeRespawn = remainingTimeBeforeRespawn;
    }

    public Item[] getItems()
    {
        return this.items;
    }



    /* ---------------------- END GETTERS AND SETTERS ---------------------- */


}
