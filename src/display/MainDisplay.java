package display;

import gamedatas.AllPlayers;
import display.classicdisplay.ClassicStoreScreen;
import display.guardchiefdisplay.GuardChiefMainMap;
import display.classicdisplay.ClassicMainMap;
import gamedatas.Map;
import display.guardchiefdisplay.GuardChiefStoreScreen;
import gamedatas.GameMode;
import gamedatas.Store;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * Class used to display player infomations.
 *
 * @author MOREL Charles
 */
public class MainDisplay implements Runnable, ActionListener {

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

    private JMenuItem aboutMenuItem;
    private JMenuBar mainMenuBar;

    public MainDisplay(AllPlayers allPlayers, Map map, GameMode gameMode) {
        this.gamePlayers = allPlayers;
        this.gameMap = map;
        this.gameMode = gameMode;
        this.playerSelectionMenuItem = new JMenuItem[this.gamePlayers.getNumberOfGuards() + this.gamePlayers.getNumberOfSpies()];
    }

    public void refreshDisplay(Map myMap, Store stores, AllPlayers players) {
    }

    public void displayLastScreen() {
    }

    private JFrame mainFrame;

    private JMenuItem menuItem;

    private JMenuItem closeMenuItem;

    private JMenuItem changePseudoMenuItem;

    private final JMenuItem[] playerSelectionMenuItem;

    @Override
    public void run() {

        // Main frame initialization
        this.mainFrame = new JFrame();
        this.mainFrame.setTitle("Spies & Guards");
        this.mainFrame.setSize(720, 610);
        this.mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // JMenu generation
        this.jmenuGeneration();

        this.mainFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionSelected) {

        JMenuItem selectedMenuItem = (JMenuItem) actionSelected.getSource();

        if (selectedMenuItem == this.changePseudoMenuItem) {
            ChangePseudo pseudoChanger = new ChangePseudo(this.playerSelectionMenuItem , this.gamePlayers);
            SwingUtilities.invokeLater(pseudoChanger);
            return;
        }

        if (selectedMenuItem == this.closeMenuItem) {

            if (JOptionPane.showConfirmDialog(this.mainFrame, "Are-you sure to close application?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                this.mainFrame.dispose();
            }
        }
        
        if (selectedMenuItem == this.aboutMenuItem)
        {
            	JOptionPane.showMessageDialog(this.mainFrame, new JLabel("Spies and Guards - Projet tutoré S2, IUT Valence, 2014 - MOREL Charles, BEGOT William, DUBOIS Thomas, WOERLY-MOUSSIER Joachim et MITTOUX Hadrien"), "About us...", JOptionPane.INFORMATION_MESSAGE);
return;
        }
    }
    
    public JMenuItem[] getPlayerSelectionMenuItem() {
        return playerSelectionMenuItem;
    }

    public void jmenuGeneration() {
        
        // MenuBar initialization
        this.mainMenuBar = new JMenuBar();
        
        JMenu gameMenu = new JMenu("Game");
        this.aboutMenuItem = new JMenuItem("About this game");
        this.aboutMenuItem.addActionListener(this);
        gameMenu.add(this.aboutMenuItem);
        this.mainMenuBar.add(gameMenu);
        this.closeMenuItem = new JMenuItem("Close");
        this.closeMenuItem.addActionListener(this);
        gameMenu.add(this.closeMenuItem);
        
        JMenu playerSelectMenu = new JMenu("Players");
        String[] allPlayersPseudos = this.gamePlayers.getAllPlayersPseudos();
        for (int i = 0; i < this.gamePlayers.getNumberOfGuards() + this.gamePlayers.getNumberOfSpies(); i++) {
            this.playerSelectionMenuItem[i] = new JMenuItem(allPlayersPseudos[i]);
            this.playerSelectionMenuItem[i].addActionListener(this);
            playerSelectMenu.add(this.playerSelectionMenuItem[i]);
        }
        playerSelectMenu.addSeparator();
        this.changePseudoMenuItem = new JMenuItem("Change a Pseudo");
        this.changePseudoMenuItem.addActionListener(this);
        playerSelectMenu.add(this.changePseudoMenuItem);
        this.mainMenuBar.add(playerSelectMenu);

        this.mainFrame.setJMenuBar(this.mainMenuBar);
    }

    
    
}
