package gamedatas;

/**
 * a class where stats are defined.
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @author WOERLY-MOUSSIER Joachim <joachim.woerly-moussier@iut-valence.fr>
 */
public class SpyStats extends Stats {
    /* ---------------------- START DECLARATIONS ---------------------- */

    private boolean teamHasDocs;

    private int remainingLives;

    public final static boolean TEAM_HAS_DOCS_DEFAULT = false;

    public final static int REMAINING_LIVES_DEFAULT = 10;

    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public SpyStats()
    {
        super();
        this.teamHasDocs = SpyStats.TEAM_HAS_DOCS_DEFAULT;
        this.remainingLives = SpyStats.REMAINING_LIVES_DEFAULT;
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */

    public void decrementRemainingLives()
    {
        this.remainingLives--;
    }
    /* ---------------------- END FUNCTION(S) ---------------------- */

    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    /**
     * @return the remainingLives
     */
    public int getRemainingLives()
    {
        return this.remainingLives;
    }


    /**
     * @return the teamHasDocs
     */
    public boolean getTeamHasDocs()
    {
        return teamHasDocs;
    }

    /**
     * @param teamHasDocs the teamHasDocs to set
     */
    public void setTeamHasDocs(boolean teamHasDocs)
    {
        this.teamHasDocs = teamHasDocs;
    }

    /**
     * @param remainingLives the remainingLives to set
     */
    public void setRemainingLives(int remainingLives)
    {
        this.remainingLives = remainingLives;
    }
    /* ---------------------- END GETTERS AND SETTERS ---------------------- */


}
