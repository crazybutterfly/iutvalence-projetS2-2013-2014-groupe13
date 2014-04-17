package gamedatas;

public class GuardPlayer extends ClassicPlayer {
    private int timeToRespawn;

    public GuardPlayer()
    {
        super();
    }
  public void useGun(AllPlayers allPlayers) {
  }

    /**
     * function to increment the waiting_for_respawn time.
     * @param time how much time we add the the waiting_for_respawn timer.
     */
    public void incrementTimeToRespawn(Integer time) 
  {
      this.timeToRespawn += time;
  }

}