package display.classicdisplay;

import display.MainDisplay;
import gamedatas.AllPlayers;
import javax.swing.*;

public class ClassicSideBar extends JPanel {

    /**
     * Reference to Main Display
     */
    private final MainDisplay refToMainDisplay;

    ClassicSideBar(MainDisplay refToMainDisplay)
    {
        this.refToMainDisplay = refToMainDisplay;
        this.add(new JLabel("SideBar not available..."));
    }

    public void refreshSideBar(AllPlayers players)
    {
    }

}
