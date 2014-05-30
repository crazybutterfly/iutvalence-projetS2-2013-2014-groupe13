package gamedatas;

import items.EmptyItem;
import items.Item;

/**
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author DUBOIS Thomas <thomas.dubois@iut-valence.fr>
 */
public class ClassicPlayer extends Player {

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
     * Orientation du joueur.
     */
    protected PlayerOrientation playerOrientation;


    /**
     * Mouvements du joueur.
     */
    protected ClassicPlayerMoves currentMoves;

    /**
     * Statut actuel du joueur.
     */
    protected PlayerStatus currentStatus;

    /**
     * prochain temps d'attente de réapparition du joueur.
     */
    protected int nextTimeBeforeRespawn;

    /**
     * Temps restant avant réapparition du joueur.
     */
    protected long respawnTime;

    /**
     * Nombre de vie initial du joueur.
     */
    protected int initialNumberOfLives;

    /**
     * Tableau recensant les type items du joueur.
     */
    protected Item[] items;

    /**
     * Item sélectionné dans l'inventaire
     */
    protected int selectedItemInInventory;

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
     * Valeur par défaut de l'orientation du joueur.
     */
    public final static PlayerOrientation PLAYER_ORIENTATION_DEFAULT = PlayerOrientation.UP;

    /**
     * Statut actuel du joueur par défaut. Ici le joueur est en vie.
     */
    public final static PlayerStatus CURRENT_STATUTS_DEFAULT = PlayerStatus.ALIVE;

    /**
     * Dernier temps d'attente de réapparition du joueur par défaut en secondes.
     * Ici, 10 secondes pour tout le monde.
     */
    public final static int LAST_TIME_BEFORE_RESPAWN_DEFAULT = 10;

    /**
     * Heure d'attente avant le respawn. Ici il est de 0.
     */
    public final static long RESPAWN_TIME_DEFAULT = 0;

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
     * Nombre de type d'item que le joueur possède en début de partie. Le joueur
     * possède un item. Si c'est un Spies, c'est un couteau et si c'est un
     * Guard, c'est un pistolet.
     */
    public final static int CURRENT_NUMBER_OF_TYPE_ITEM_POCESSED_DEFAULT = 1;

    /**
     * item selectionné par défaut dans l'inventaire.
     */
    public final static int SELECTED_NUMBER_ITEM_IN_INVENTORY = 0;

    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public ClassicPlayer(Map refToMap, AllPlayers refToPlayers)
    {
        super(refToMap, refToPlayers);
        this.posX = ClassicPlayer.POS_X_DEFAULT;
        this.posY = ClassicPlayer.POS_Y_DEFAULT;
        this.playerOrientation = ClassicPlayer.PLAYER_ORIENTATION_DEFAULT;
        this.currentStatus = ClassicPlayer.CURRENT_STATUTS_DEFAULT;
        this.nextTimeBeforeRespawn = ClassicPlayer.LAST_TIME_BEFORE_RESPAWN_DEFAULT;
        this.respawnTime = ClassicPlayer.RESPAWN_TIME_DEFAULT;
        this.initialNumberOfLives = ClassicPlayer.INITIAL_NUMBER_OF_LIVES;
        this.items = new Item[ClassicPlayer.MAXIMUM_NUMBER_OF_ITEM_TYPE];
        for (int i = 0; i < ClassicPlayer.MAXIMUM_NUMBER_OF_ITEM_TYPE; i++)
        {
            this.items[i] = new EmptyItem();
        }
        this.currentNumberOfTypeItemPocessed = ClassicPlayer.CURRENT_NUMBER_OF_TYPE_ITEM_POCESSED_DEFAULT;
        this.selectedItemInInventory = ClassicPlayer.SELECTED_NUMBER_ITEM_IN_INVENTORY;
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
        this.stats.numberOfDeaths++;
    }

    public void refeshKilledPlayerStatuts()
    {
        if ((System.currentTimeMillis() >= this.respawnTime) && (this.currentStatus != PlayerStatus.DEAD))
        {
            this.currentStatus = PlayerStatus.ALIVE;
        }
    }

    public int timeBeforeRespawnInSeconds()
    {
        long currentSystemTime = System.currentTimeMillis();
        return (int) ((this.respawnTime - currentSystemTime) / 1000);
    }

    public void dropSelectedItem()
    {
        if (this.items[this.selectedItemInInventory].getNumberOfItemsOfThisType() != 1)
        {
            this.items[this.selectedItemInInventory].setNumberOfItemsOfThisType(this.items[this.selectedItemInInventory].getNumberOfItemsOfThisType() - 1);
            this.items[this.selectedItemInInventory].setXPos(this.posX);
            this.items[this.selectedItemInInventory].setYPos(this.posY);
            this.currentMap.addItemOnTheMap(this.items[this.selectedItemInInventory].getNewItem());
        }
        else
        {
            this.items[this.selectedItemInInventory] = new EmptyItem();
        }
    }


    public boolean getItemFromName(String itemName)
    {
        boolean exist = false;
        String currentItemName = "";
        for (int i = 0; i < this.currentNumberOfTypeItemPocessed && !currentItemName.equals(itemName); i++)
        {
            currentItemName = this.items[i].getItemName();
            if (currentItemName.equals(itemName))
            {
                exist = true;
            }
        }
        return exist;
    }

    public int getPositionItemFromName(String itemName)
    {
        int itemPosition = 0;
        String currentItemName = "";
        for (int i = 0; i < this.currentNumberOfTypeItemPocessed && !currentItemName.equals(itemName); i++)
        {
            currentItemName = this.items[i].getItemName();
            itemPosition = i;
        }
        return itemPosition;
    }

    public void deleteItem(String item)
    {
        if (this.items[this.getPositionItemFromName(item)].getNumberOfItemsOfThisType() == 1)
        {
            this.items[this.getPositionItemFromName(item)] = new EmptyItem();
        }
        else
        {
            this.items[this.getPositionItemFromName(item)].setNumberOfItemsOfThisType(this.items[this.getPositionItemFromName(item)].getNumberOfItemsOfThisType() - 1);
        }

    }

    public void useSelectedItem()
    {
        this.items[this.selectedItemInInventory].useItem(this);
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
     * @return the respawnTime
     */
    public long getRespawnTime()
    {
        return this.respawnTime;
    }

    public Item[] getItems()
    {
        return this.items;
    }

    public PlayerOrientation getPlayerOrientation()
    {
        return this.playerOrientation;
    }

    public void setPlayerOrientation(PlayerOrientation orientation)
    {
        this.playerOrientation = orientation;
    }

    public int getSelectedItemInInventory()
    {
        return selectedItemInInventory;
    }

    public void setSelectedItemInInventory(int selectedItemInInventory)
    {
        this.selectedItemInInventory = selectedItemInInventory;
    }

    public ClassicPlayerMoves getCurrentMoves()
    {
        return currentMoves;
    }

    /* ---------------------- END GETTERS AND SETTERS ---------------------- */

}
