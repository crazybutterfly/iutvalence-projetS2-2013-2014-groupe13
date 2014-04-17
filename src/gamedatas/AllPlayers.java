package gamedatas;


/**
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @author WOERLY-MOUSSIER Joachim <joachim.woerly-moussier@iut-valence.fr>
 * @author BEGOT William <william.begot@iut-valence.fr>
 */
public class AllPlayers {

  private final int numberOfGuards;

  private final int numberOfSpies;

GuardPlayer[] guardsArray;
SpyPlayer[] spiesArray;

  private Player  myPlayer;

  public AllPlayers(int numberOfGuards, int numberOfSpies)
  {
      this.numberOfGuards = numberOfGuards;
      this.numberOfSpies = numberOfSpies;
      this.guardsArray = new GuardPlayer[this.numberOfGuards];
      this.spiesArray = new SpyPlayer[this.numberOfSpies];
  }
  
    /**
     * Function returning the stats of the guard team.
     * @return the stats of the guard team.
     */
    public Stats getGuardTeamStats() {
        Stats stats;
        stats = new Stats();
        for (int i=0; i<numberOfGuards; i++)
        {
      //      stats += guardsArray[i].getStats();
        }
      return stats;
  }

    /**
     * Function returning the stats of the Spie Team.
     * @return the stats of the Spie Team.
     */
    public Stats getSpiesTeamStats() {
      Stats stats;
        stats = new Stats();
        for (int i=0; i<numberOfSpies; i++)
        {
     //       stats += spiesArray[i].getStats();
        }
      return stats;
  }

  public int[] getPlayersInformations(ClassicPlayer player) {
      int[] array;
      array = new int[7];
      array[0] = player.getStats().getNumberOfKills();
      array[1] = player.getStats().getTimeSurvived();
      array[2] = player.getStats().getTimesHandsGotOnTheDocs();
      array[3] = player.getStats().getRemainingLives();
      array[4] = player.getPosX();
      array[5] = player.getPosY();
      array[6] = player.getTimeToRespawn();
      //TODO : fill the array with player's infos or find a better way to give player's infos.
      return array;
      
  }

  public void AllPlayers(Integer nbOfGuards, Integer nbOfSpies) {
  }

}