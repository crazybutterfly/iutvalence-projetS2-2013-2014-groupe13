package gamedatas;
/**
 *
 * SpyStore class
 *
 *
 *
 * @author MITTOUX Hadrien <hadrien.mittoux@iut-valence.fr>
 */
public class SpyStore extends Store
{
    /* ---------------------- START DECLARATIONS ---------------------- */

    /* ---------------------- END DECLARATIONS ---------------------- */
    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */
    /* ---------------------- START FUNCTION(S) ---------------------- */
    /**
     *
     * transfer a number of items from the store to a player.
     *
     * @param item name of the item to transfer
     * @param number number of items to transfer
     * @param player current player
     */
    public void addItemPlayer(String item, int number, ClassicPlayer player)
    {
       
        if (this.changeStoreCapacity(item, number)){
            if (player.getItemFromName(item)){
                player.getItems()[player.getPositionItemFromName(item)].setNumberOfItemsOfThisType(player.getItems()[player.getPositionItemFromName(item)].getNumberOfItemsOfThisType()+number);
            }
            else{
                // message d'alerte
            }
            
        }
        else{
            //message d'alerte
        }
        
        
    }
    /* ---------------------- END FUNCTION(S) ---------------------- */
    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    /* ---------------------- END GETTERS AND SETTERS ---------------------- */
}
