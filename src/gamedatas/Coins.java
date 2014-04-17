package gamedatas;

/**
 * Class which store coins for a player.
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public class Coins {

  private int quantity;

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