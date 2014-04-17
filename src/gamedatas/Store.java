package gamedatas;

 
import gamecore.Engine;

public abstract class Store {

    /**
   * 
   * @element-type Item
   */
  public items.Item  myItem;
    public Engine myEngine;

 /* 
    TODO : work out how to do that function.
    
    public Item buyItem( String name) {
      return new Item(name);
  }
*/
  public void unlockItems() {
  }

}