package gamedatas;


import java.util.Vector;


public class ClassicPlayer extends Player {

  private int posX;

  private int posY;

  private PlayerStatus status;

  public int lastTimeBeforeRespawn;

  public int timeToRespawn;

  public int initialNumberOfLives;

  public int remainingLives;

  public int adversaryKilled;

    /**
   * 
   * @element-type Item
   */
  public items.Item[] items;
  private Stats stats;

  public void updatePosition(Integer newPosX, Integer newPosY) {
      this.posX = newPosX;
      this.posY = newPosY;
  }

  @Override
  public Stats getStats() {
      return this.stats;
  }

  public ClassicPlayer() 
  {
      super();
  }

}