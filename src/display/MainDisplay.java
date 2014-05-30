package display;

import gamedatas.AllPlayers;
import display.classicdisplay.ClassicStoreScreen;
import display.guardchiefdisplay.GuardChiefMainMap;
import display.classicdisplay.ClassicMainMap;
import gamedatas.Map;
import display.guardchiefdisplay.GuardChiefStoreScreen;
import gamedatas.GameMode;
import gamedatas.Store;
import javax.swing.*;


/**
 * Class used to display player infomations.
 *
 * @author MOREL Charles
 */
public class MainDisplay implements Runnable {

    /* ---------------------- START DECLARATIONS ---------------------- */
    public ClassicMainMap myClassicMainMap;

    public ClassicStoreScreen myClassicStoreScreen;

    public SideBar mySideBar;

    public MiniMap myMiniMap;

    public GuardChiefMainMap myGuardChiefMainMap;

    public GuardChiefStoreScreen myGuardChiefStoreScreen;

    /**
     * The number of the selected player.
     */
    private int playerSelected;

    /**
     * Reference to AllPlayers of the game.
     */
    private final AllPlayers gamePlayers;

    /**
     * Reference to the map of the game.
     */
    private final Map gameMap;

    /**
     * Reference to game mode.
     */
    private final GameMode gameMode;

    private JFrame mainFrame;

    private JMenuMainDisplay jmenuBar;
    /* ---------------------- END DECLARATIONS ---------------------- */
    
    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public MainDisplay(AllPlayers allPlayers, Map map, GameMode gameMode)
    {
        this.gamePlayers = allPlayers;
        this.gameMap = map;
        this.gameMode = gameMode;

    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */
    
    /* ---------------------- START FUNCTION(S) ---------------------- */
    public void refreshDisplay(Map myMap, Store stores, AllPlayers players)
    {
    }

    public void displayLastScreen()
    {
    }


    @Override
    public void run()
    {

        // Main frame initialization
        this.mainFrame = new JFrame();
        this.mainFrame.setTitle("Spies & Guards");
        this.mainFrame.setSize(720, 610);
        this.mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // JMenu generation
        this.jmenuBar = new JMenuMainDisplay(this);
        this.mainFrame.setJMenuBar(this.jmenuBar);

        this.mainFrame.setVisible(true);

    }
    /* ---------------------- END FUNCTION(S) ---------------------- */
    
    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    /**
     * @return the gamePlayers
     */
    public AllPlayers getGamePlayers()
    {
        return gamePlayers;
    }

    /**
     * @return the gameMap
     */
    public Map getGameMap()
    {
        return gameMap;
    }

    /**
     * @return the gameMode
     */
    public GameMode getGameMode()
    {
        return gameMode;
    }

    /**
     * @return the mainFrame
     */
    public JFrame getMainFrame()
    {
        return mainFrame;
    }
    /* ---------------------- END GETTERS AND SETTERS ---------------------- */

}
