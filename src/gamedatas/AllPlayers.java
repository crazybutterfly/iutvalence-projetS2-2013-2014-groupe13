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
    private final GuardPlayer[] guardsArray;

    /**
     * Tableau listant tous les Spies de la partie.
     */
    private final SpyPlayer[] spiesArray;

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
    
    private GameMode gameMode;

    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    /**
     *
     * @param numberOfGuards nombre de Guards.
     * @param numberOfSpies nombre de Spies.
     * @param refToMap référence vers la map.
     */
    public AllPlayers(int numberOfGuards, int numberOfSpies, Map refToMap, GameMode gameMode)
    {
        this.numberOfGuards = numberOfGuards;
        this.numberOfSpies = numberOfSpies;
        this.guardsArray = new GuardPlayer[this.numberOfGuards - 1];
        this.spiesArray = new SpyPlayer[this.numberOfSpies];
        for (int i = 0; i < this.numberOfGuards - 1; i++) {
            this.guardsArray[i] = new GuardPlayer(i + 1, refToMap, this);
        }
        for (int i = 0; i < this.numberOfSpies; i++) {
            this.spiesArray[i] = new SpyPlayer(i + 1, refToMap, this);
        }
        this.guardChiefPlayer = new GuardChiefPlayer(refToMap, this);
        this.guardTeamStats = new Stats();
        this.spyTeamStats = new SpyStats();
        this.gameMode = gameMode;
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
        for (int i = 0; i < getNumberOfGuards() - 2; i++) {
            newGuardTeamStats.setNumberOfKills(this.getGuardsArray()[i].getStats().getNumberOfKills() + newGuardTeamStats.getNumberOfKills());
            newGuardTeamStats.setNumberOfDeaths(this.getGuardsArray()[i].getStats().getNumberOfDeaths() + newGuardTeamStats.getNumberOfDeaths());
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
        for (int i = 0; i < getNumberOfSpies() - 1; i++) {
            newSpyTeamStats.setNumberOfKills(this.getSpiesArray()[i].getStats().getNumberOfKills() + newSpyTeamStats.getNumberOfKills());
            newSpyTeamStats.setNumberOfDeaths(this.getSpiesArray()[i].getStats().getNumberOfDeaths() + newSpyTeamStats.getNumberOfDeaths());
            newSpyTeamStats.setRemainingLives(this.getSpiesArray()[i].getStats().getRemainingLives() + newSpyTeamStats.getRemainingLives());
            if (this.getSpiesArray()[i].getStats().getTeamHasDocs()) {
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
        for (int i = 1; i < this.numberOfGuards; i++) {
            allPlayersPseudos[i] = this.getGuardsArray()[i - 1].getPseudo();
        }
        for (int i = this.numberOfGuards; i < totalNumberOfPlayers; i++) {
            allPlayersPseudos[i] = this.getSpiesArray()[i - this.numberOfGuards].getPseudo();
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

    /**
     * @return the guardsArray
     */
    public GuardPlayer[] getGuardsArray() {
        return guardsArray;
    }

    /**
     * @return the spiesArray
     */
    public SpyPlayer[] getSpiesArray() {
        return spiesArray;
    }
    
    public GameMode getGameMode()
    {
        return this.gameMode;
    }

    public GuardChiefPlayer getGuardChiefPlayer() {
        return guardChiefPlayer;
    }
    
    public void updateAllStatuses()
    {
        for (int i = 0; i < this.numberOfGuards - 1; i++) {
            this.guardsArray[i].refeshKilledPlayerStatuts();
        }
        for (int i = 0; i < this.numberOfSpies; i++) {
            this.spiesArray[i].refeshKilledPlayerStatuts();
        }
    }
    

}
