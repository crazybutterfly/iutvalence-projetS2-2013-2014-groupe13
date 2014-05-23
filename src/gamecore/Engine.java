package gamecore;

import gamedatas.AllPlayers;
import playersinteractions.PlayerInputs;
import gamedatas.Store;
import display.MainDisplay;
import gamedatas.GameMode;
import gamedatas.Map;
import javax.swing.SwingUtilities;
import utils.GameInformationLoaderFromFile;

/**
 * Game Engine. Primordial class used during the game, process cycles for
 * players etc.
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public class Engine {

    /* ---------------------- START DECLARATIONS ---------------------- */
    /**
     * The number of players in the game
     */
    public int numberOfPlayer;

    /**
     * IHM used to display the game for the player.
     */
    public MainDisplay mainDisplay;

    /**
     * All players informations.
     */
    public AllPlayers allPlayers;

    /**
     * Datas of the different quests of the game.
     */
    public GameMode gameMode;

    /**
     * All Map datas.
     */
    public Map map;

    /**
     * All store datas.
     */
    public Store store;

    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public Engine(GameInformations gameInfos) {
        this.numberOfPlayer = gameInfos.getNumberOfGuards() + gameInfos.getNumberOfSpies();
        this.map = GameInformationLoaderFromFile.loadMapFromFile(gameInfos.getMapLocation());
        this.gameMode = GameInformationLoaderFromFile.loadQuestsFromFile(gameInfos.getQuestsLocation());
        this.allPlayers = new AllPlayers(gameInfos.getNumberOfGuards(), gameInfos.getNumberOfSpies(), this.map, this.gameMode);
        this.mainDisplay = new MainDisplay();
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    public void doInteraction(PlayerInputs playerInput) {

    }

    public void classicPlayerPlay() {
    }

    public void classicPlayerWaitingRespawn() {
    }

    public void classicPlayerDead() {
    }

    public void startGame() {
        
        SwingUtilities.invokeLater(this.mainDisplay);
    }
    /* ---------------------- END FUNCTION(S) ---------------------- */

    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    /* ---------------------- END GETTERS AND SETTERS ---------------------- */
}
