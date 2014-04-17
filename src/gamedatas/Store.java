package gamedatas;

import java.util.Vector;
import gamecore.Engine;

public abstract class Store {

    /**
   * 
   * @element-type Item
   */
  public Vector  myItem;
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