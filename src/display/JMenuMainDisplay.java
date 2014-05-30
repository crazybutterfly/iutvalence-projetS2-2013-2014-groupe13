package display;

import java.awt.event.*;
import javax.swing.*;

/**
 * JMenuBar used for main display.
 * Actions do in this JMenuBar are perform by this class too.
 *
 * @author MOREL Charles
 */
public class JMenuMainDisplay extends JMenuBar implements ActionListener {

    /* ---------------------- START DECLARATIONS ---------------------- */
    private final MainDisplay refToMainDisplay;

    private final JMenuItem aboutMenuItem;

    private JMenuItem menuItem;

    private final JMenuItem closeMenuItem;

    private final JMenuItem changePseudoMenuItem;

    private final JMenuItem[] playerSelectionMenuItem;
    /* ---------------------- END DECLARATIONS ---------------------- */
    
    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public JMenuMainDisplay(MainDisplay refToMainDisplay)
    {

        // Attributes initialisation

        this.refToMainDisplay = refToMainDisplay;
        this.playerSelectionMenuItem = new JMenuItem[this.refToMainDisplay.getGamePlayers().getNumberOfGuards() + this.refToMainDisplay.getGamePlayers().getNumberOfSpies()];

        // MenuBar initialization

        JMenu gameMenu = new JMenu("Game");
        this.aboutMenuItem = new JMenuItem("About this game");
        this.aboutMenuItem.addActionListener(this);
        gameMenu.add(this.aboutMenuItem);
        this.add(gameMenu);
        this.closeMenuItem = new JMenuItem("Close");
        this.closeMenuItem.addActionListener(this);
        gameMenu.add(this.closeMenuItem);

        JMenu playerSelectMenu = new JMenu("Players");
        String[] allPlayersPseudos = this.refToMainDisplay.getGamePlayers().getAllPlayersPseudos();
        for (int i = 0; i < this.refToMainDisplay.getGamePlayers().getNumberOfGuards() + this.refToMainDisplay.getGamePlayers().getNumberOfSpies(); i++)
        {
            this.playerSelectionMenuItem[i] = new JMenuItem(allPlayersPseudos[i]);
            this.playerSelectionMenuItem[i].addActionListener(this);
            playerSelectMenu.add(this.playerSelectionMenuItem[i]);
        }
        playerSelectMenu.addSeparator();
        this.changePseudoMenuItem = new JMenuItem("Change a Pseudo");
        this.changePseudoMenuItem.addActionListener(this);
        playerSelectMenu.add(this.changePseudoMenuItem);
        this.add(playerSelectMenu);
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    @Override
    public void actionPerformed(ActionEvent actionSelected)
    {

        JMenuItem selectedMenuItem = (JMenuItem) actionSelected.getSource();

        if (selectedMenuItem == this.changePseudoMenuItem)
        {
            ChangePseudo pseudoChanger = new ChangePseudo(this.playerSelectionMenuItem, this.refToMainDisplay.getGamePlayers());
            SwingUtilities.invokeLater(pseudoChanger);
            return;
        }

        if (selectedMenuItem == this.closeMenuItem)
        {

            if (JOptionPane.showConfirmDialog(this.refToMainDisplay.getMainFrame(), "Are-you sure to close application?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
            {
                this.refToMainDisplay.getMainFrame().dispose();
            }
        }

        if (selectedMenuItem == this.aboutMenuItem)
        {
            JOptionPane.showMessageDialog(this.refToMainDisplay.getMainFrame(), new JLabel("Spies and Guards - Projet tutoré S2, IUT Valence, 2014 - MOREL Charles, BEGOT William, DUBOIS Thomas, WOERLY-MOUSSIER Joachim et MITTOUX Hadrien"), "About us...", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }
    /* ---------------------- END FUNCTION(S) ---------------------- */
    
    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    public JMenuItem[] getPlayerSelectionMenuItem()
    {
        return playerSelectionMenuItem;
    }
    /* ---------------------- END GETTERS AND SETTERS ---------------------- */


}
