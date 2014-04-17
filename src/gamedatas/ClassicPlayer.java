package gamedatas;


 


public class ClassicPlayer extends Player {

  private int posX;

  private int posY;

  private PlayerStatus status;

  public int lastTimeBeforeRespawn;

  private int timeToRespawn;

  public int initialNumberOfLives;

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
     * @return the status
     */
    public PlayerStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    /**
     * @return the timeToRespawn
     */
    public int getTimeToRespawn() {
        return timeToRespawn;
    }

    /**
     * @param timeToRespawn the timeToRespawn to set
     */
    public void setTimeToRespawn(int timeToRespawn) {
        this.timeToRespawn = timeToRespawn;
    }

}