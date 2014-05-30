package display.classicdisplay;

import display.MainDisplay;
import javax.swing.*;

/**
 *
 * @author MOREL Charles
 */
public class WaitingForRespawnClassicPlayerJPanel extends JPanel {

    /**
     * Reference to Main Display
     */
    private MainDisplay refToMainDisplay;


    public WaitingForRespawnClassicPlayerJPanel(MainDisplay refToMainDisplay)
    {
        this.refToMainDisplay = refToMainDisplay;

        if (this.refToMainDisplay.getPlayerSelected() < this.refToMainDisplay.getRefToGamePlayers().getNumberOfGuards())
        {
            this.add(new JLabel("The player is waiting for respawn: " + this.refToMainDisplay.getRefToGamePlayers().getGuardsArray()[this.refToMainDisplay.getPlayerSelected() - 1].timeBeforeRespawnInSeconds() + " seconds"));
        }
        else
        {
            this.add(new JLabel("The player is waiting for respawn: " + this.refToMainDisplay.getRefToGamePlayers().getSpiesArray()[this.refToMainDisplay.getPlayerSelected() - this.refToMainDisplay.getRefToGamePlayers().getNumberOfGuards()].timeBeforeRespawnInSeconds() + " seconds"));
        }
    }

}
