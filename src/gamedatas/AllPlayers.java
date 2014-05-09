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
    /**
     * Attribut définissant le nombre de Guards.
     */
    private final int numberOfGuards;

    /**
     * Attribut définissant le nombre de Spies.
     */
    private final int numberOfSpies;

    /**
     * Tableau listant tous les Guards de la partie.
     */
    private GuardPlayer[] guardsArray;

    /**
     * Tableau listant tous les Spies de la partie.
     */
    private SpyPlayer[] spiesArray;

    /**
     * Objet de stockage des statistiques de l'équipe des Guards.
     */
    private Stats guardTeamStats;

    /**
     * Objet de stockage des statistiques de l'équipe des Spies.
     */
    private SpyStats spyTeamStats;

    /**
     * Attribut stockant les caractéristiques du joueur Guard Chief.
     */
    private GuardChiefPlayer guardChiefPlayer;

    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    /**
     *
     * @param numberOfGuards nombre de Guards.
     * @param numberOfSpies nombre de Spies.
     */
    public AllPlayers(int numberOfGuards, int numberOfSpies)
    {
        this.numberOfGuards = numberOfGuards;
        this.numberOfSpies = numberOfSpies;
        this.guardsArray = new GuardPlayer[this.numberOfGuards - 1];
        this.spiesArray = new SpyPlayer[this.numberOfSpies];
        for (int i = 0; i < this.numberOfGuards - 1; i++)
        {
            this.guardsArray[i] = new GuardPlayer(i + 1);
        }
        for (int i = 0; i < this.numberOfSpies; i++)
        {
            this.spiesArray[i] = new SpyPlayer(i + 1);
        }
        this.guardChiefPlayer = new GuardChiefPlayer();
        this.guardTeamStats = new Stats();
        this.spyTeamStats = new SpyStats();
    }


    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    /**
     * Function updating the stats of the guard team.
     */
    public void updateGuardTeamStats()
    {
        Stats newGuardTeamStats;
        newGuardTeamStats = new Stats();
        for (int i = 0; i < getNumberOfGuards() - 2; i++)
        {
            newGuardTeamStats.setNumberOfKills(this.guardsArray[i].getStats().getNumberOfKills() + newGuardTeamStats.getNumberOfKills());
            newGuardTeamStats.setNumberOfDeaths(this.guardsArray[i].getStats().getNumberOfDeaths() + newGuardTeamStats.getNumberOfDeaths());
        }
        this.guardTeamStats = newGuardTeamStats;
    }

    /**
     * Function updating the stats of the Spie Team.
     */
    public void updateSpiesTeamStats()
    {
        SpyStats newSpyTeamStats;
        newSpyTeamStats = new SpyStats();
        for (int i = 0; i < getNumberOfSpies() - 1; i++)
        {
            newSpyTeamStats.setNumberOfKills(this.spiesArray[i].getStats().getNumberOfKills() + newSpyTeamStats.getNumberOfKills());
            newSpyTeamStats.setNumberOfDeaths(this.spiesArray[i].getStats().getNumberOfDeaths() + newSpyTeamStats.getNumberOfDeaths());
            newSpyTeamStats.setRemainingLives(this.spiesArray[i].getStats().getRemainingLives() + newSpyTeamStats.getRemainingLives());
            if (this.spiesArray[i].getStats().getTeamHasDocs())
            {
                newSpyTeamStats.setTeamHasDocs(true);
            }
        }
        this.spyTeamStats = newSpyTeamStats;
    }

    public String[] getAllPlayersPseudos()
    {
        int totalNumberOfPlayers = this.numberOfGuards + this.numberOfSpies;
        String[] allPlayersPseudos = new String[totalNumberOfPlayers];
        allPlayersPseudos[0] = this.guardChiefPlayer.getPseudo();
        for (int i = 1; i < this.numberOfGuards; i++)
        {
            allPlayersPseudos[i] = this.guardsArray[i - 1].getPseudo();
        }
        for (int i = this.numberOfGuards; i < totalNumberOfPlayers; i++)
        {
            allPlayersPseudos[i] = this.spiesArray[i - this.numberOfGuards].getPseudo();
        }
        return allPlayersPseudos;
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

    /**
     * @return the stats of the Guard Team (from last update)
     */
    public Stats getGuardTeamStats()
    {
        return guardTeamStats;
    }

    /**
     * @return the stats of the Spy Team (from last update)
     */
    public SpyStats getSpyTeamStats()
    {
        return spyTeamStats;
    }
    /* ---------------------- END GETTERS & SETTERS ---------------------- */

}
