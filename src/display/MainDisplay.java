package display;

import display.classicdisplay.*;
import gamedatas.AllPlayers;
import display.guardchiefdisplay.*;
import gamedatas.*;
import javax.swing.*;


/**
 * Class used to display player infomations.
 *
 * @author MOREL Charles
 */
public class MainDisplay implements Runnable {

    /* ---------------------- START DECLARATIONS ---------------------- */
//    public ClassicMainMap myClassicMainMap;
//
//    public ClassicStoreScreen myClassicStoreScreen;
//
//    public SideBar mySideBar;
//
//    public MiniMap myMiniMap;
//
//    public GuardChiefMainMap myGuardChiefMainMap;
//
//    public GuardChiefStoreScreen myGuardChiefStoreScreen;

    /**
     * The number of the selected player.
     */
    private int playerSelected;

    /**
     * Reference to AllPlayers of the game.
     */
    private final AllPlayers refToGamePlayers;

    /**
     * Reference to the map of the game.
     */
    private final Map refToGameMap;

    /**
     * Reference to game mode.
     */
    private final GameMode refToGameMode;

    /**
     * The main frame of the game.
     */
    private JFrame mainFrame;

    /**
     * The JMenuBar of the main frame of the game.
     */
    private JMenuMainDisplay jmenuBar;

    private JPanel currentJPanel;

    /**
     * The number of the selected player by default.
     */
    public final static int PLAYER_SELECTED_DEFAULT = 0;
    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public MainDisplay(AllPlayers allPlayers, Map map, GameMode gameMode)
    {
        this.refToGamePlayers = allPlayers;
        this.refToGameMap = map;
        this.refToGameMode = gameMode;
        this.playerSelected = MainDisplay.PLAYER_SELECTED_DEFAULT;
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
        this.mainFrame.setSize(700, 700);
        this.mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // JMenu initialization
        this.jmenuBar = new JMenuMainDisplay(this);
        this.mainFrame.setJMenuBar(this.jmenuBar);

        // JPanel initialization
        this.updateTheJPannel();

        // JFrame Display
        this.mainFrame.setVisible(true);

    }


    public void updateTheJPannel()
    {
        if (this.playerSelected == 0)
        {
            this.currentJPanel = new GuardChiefPlayerJPanel(this);
        }
        else
        {
            if (this.playerSelected < this.refToGamePlayers.getNumberOfGuards())
            {
                if (this.refToGamePlayers.getGuardsArray()[playerSelected - 1].getCurrentStatus() == PlayerStatus.ALIVE)
                {
                    this.currentJPanel = new AliveClassicPlayerJPanel(this);
                }
                else if (this.refToGamePlayers.getGuardsArray()[playerSelected - 1].getCurrentStatus() == PlayerStatus.WAITING_FOR_RESPAWN)
                {
                    this.currentJPanel = new WaitingForRespawnClassicPlayerJPanel(this);
                }
                else
                {
                    this.currentJPanel = new DeadClassicPlayerJPanel(this);
                }
            }
            else
            {
                if (this.refToGamePlayers.getSpiesArray()[playerSelected - this.getRefToGamePlayers().getNumberOfGuards()].getCurrentStatus() == PlayerStatus.ALIVE)
                {
                    this.currentJPanel = new AliveClassicPlayerJPanel(this);
                }
                else if (this.refToGamePlayers.getSpiesArray()[playerSelected - this.getRefToGamePlayers().getNumberOfGuards()].getCurrentStatus() == PlayerStatus.WAITING_FOR_RESPAWN)
                {
                    this.currentJPanel = new WaitingForRespawnClassicPlayerJPanel(this);
                }
                else
                {
                    this.currentJPanel = new DeadClassicPlayerJPanel(this);
                }
            }
        }
        this.mainFrame.setContentPane(this.currentJPanel);
        this.mainFrame.revalidate();
    }
    /* ---------------------- END FUNCTION(S) ---------------------- */

    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    /**
     * @return the refToGamePlayers
     */
    public AllPlayers getRefToGamePlayers()
    {
        return refToGamePlayers;
    }

    /**
     * @return the refToGameMap
     */
    public Map getRefToGameMap()
    {
        return refToGameMap;
    }

    /**
     * @return the refToGameMode
     */
    public GameMode getRefToGameMode()
    {
        return refToGameMode;
    }

    /**
     * @return the mainFrame
     */
    public JFrame getMainFrame()
    {
        return mainFrame;
    }

    /**
     * @param playerSelected
     */
    public void setPlayerSelected(int playerSelected)
    {
        this.playerSelected = playerSelected;
    }

    public int getPlayerSelected()
    {
        return playerSelected;
    }

    public AliveClassicPlayerJPanel getCurrentJPanel()
    {
        return (AliveClassicPlayerJPanel) currentJPanel;
    }


    /* ---------------------- END GETTERS AND SETTERS ---------------------- */
}
