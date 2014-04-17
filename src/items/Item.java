package items;

import gamedatas.Store;
import gamedatas.ClassicPlayer;


public class Item {
    
  public String itemName;

  public boolean usableByASpy;

  public boolean usableByAGuard;

  public int timeBeforeUnlock;

  public int itemPrice;

    public ClassicPlayer myClassicPlayer;
    public Store myStore;

  public void useItem() {
  }

  public Item() {
  }

}