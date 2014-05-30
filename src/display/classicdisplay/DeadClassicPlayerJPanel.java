package display.classicdisplay;

import display.MainDisplay;
import javax.swing.*;

/**
 *
 * @author MOREL Charles
 */
public class DeadClassicPlayerJPanel extends JPanel {

    /**
     * Reference to Main Display
     */
    private MainDisplay refToMainDisplay;


    public DeadClassicPlayerJPanel(MainDisplay refToMainDisplay)
    {
        this.refToMainDisplay = refToMainDisplay;
        this.add(new JLabel("The player is dead"));
    }

}
