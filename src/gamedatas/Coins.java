package gamedatas;


public class Coins {

  private int quantity;

    /**
     * joueur espion.
     */
    public SpyPlayer spyPlayer;

    /**
     * le chef des gardes.
     */
    public GuardChiefPlayer guardChiefPlayer;

    /**
     * a procedure to add coins
     * @param quantity how many coins we add
     */
    public void addingCoin(Integer quantity) {
      this.quantity += quantity;
  }

    /**
     * a procedure to remove coins
     * @param quantity how many coins we remove
     */
    public void removeCoin(Integer quantity) {
      this.quantity -= quantity;
  }

}