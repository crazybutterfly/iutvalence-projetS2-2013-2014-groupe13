package gamedatas;

/**
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @author WOERLY-MOUSSIER Joachim <joachim.woerly-moussier@iut-valence.fr>
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author DUBOIS Thomas <thomas.dubois@iut-valence.fr>
 */
public class AllPlayers
{

    /* ---------------------- START DECLARATIONS ---------------------- */

    private final int numberOfGuards;

    private final int numberOfSpies;

    GuardPlayer[] guardsArray;

    SpyPlayer[] spiesArray;

    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public AllPlayers(int numberOfGuards, int numberOfSpies)
    {
        this.numberOfGuards = numberOfGuards;
        this.numberOfSpies = numberOfSpies;
        this.guardsArray = new GuardPlayer[this.numberOfGuards];
        this.spiesArray = new SpyPlayer[this.numberOfSpies];
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    /**
     * Function returning the stats of the guard team.
     *
     * @return the stats of the guard team.
     */
    public Stats getGuardTeamStats()
    {
        Stats stats;
        stats = new Stats();
        for (int i = 0; i < getNumberOfGuards(); i++) {
            //      stats += guardsArray[i].getStats();
        }
        return stats;
    }

    /**
     * Function returning the stats of the Spie Team.
     *
     * @return the stats of the Spie Team.
     */
    public Stats getSpiesTeamStats()
    {
        Stats stats;
        stats = new Stats();
        for (int i = 0; i < getNumberOfSpies(); i++) {
            //       stats += spiesArray[i].getStats();
        }
        return stats;
    }

    public int[] getPlayersInformations(ClassicPlayer player)
    {
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

    /* ---------------------- END FUNCTION(S) ---------------------- */

    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    /**
     * @return the numberOfGuards
     */
    public int getNumberOfGuards()
    {
        return numberOfGuards;
    }

    /**
     * @return the numberOfSpies
     */
    public int getNumberOfSpies()
    {
        return numberOfSpies;
    }
    /* ---------------------- END GETTERS & SETTERS ---------------------- */

}
