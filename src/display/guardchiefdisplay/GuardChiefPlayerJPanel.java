package display.guardchiefdisplay;

import display.MainDisplay;
import javax.swing.*;

/**
 *
 * @author MOREL Charles
 */
public class GuardChiefPlayerJPanel extends JPanel {

    /**
     * Reference to Main Display
     */
    private MainDisplay refToMainDisplay;


    public GuardChiefPlayerJPanel(MainDisplay refToMainDisplay)
    {
        this.refToMainDisplay = refToMainDisplay;
        this.add(new JLabel("test chef"));

    }

}
