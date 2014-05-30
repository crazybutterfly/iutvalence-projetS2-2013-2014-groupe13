package display.classicdisplay;

import display.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author MOREL Charles
 */
public class AliveClassicPlayerJPanel extends JPanel {

    /**
     * Reference to Main Display
     */
    private final MainDisplay refToMainDisplay;

    private final ClassicMainMap mainMap;

    private final Inventory inventory;

    private final MiniMap miniMap;

    private final ClassicSideBar sidebar;

    private MouseAndKeybordListener keyboardAndMouseListener;


    public AliveClassicPlayerJPanel(MainDisplay refToMainDisplay)
    {

        // Attributes initialization
        this.refToMainDisplay = refToMainDisplay;

        // Components initialization

        this.mainMap = new ClassicMainMap(this.refToMainDisplay);
        this.keyboardAndMouseListener = new MouseAndKeybordListener(this.refToMainDisplay);
        this.mainMap.addMouseListener(this.keyboardAndMouseListener);
        this.mainMap.setSize(1000, 1000);
        this.mainMap.setMaximumSize(new Dimension(1000, 1000));
        this.mainMap.setMinimumSize(new Dimension(1000, 1000));
        this.mainMap.setPreferredSize(new Dimension(1000, 1000));
        this.inventory = new Inventory(this.refToMainDisplay);
        this.miniMap = new MiniMap(this.refToMainDisplay);
        this.miniMap.addMouseListener(this.keyboardAndMouseListener);
        this.sidebar = new ClassicSideBar(this.refToMainDisplay);
        this.sidebar.addMouseListener(this.keyboardAndMouseListener);
        this.setLayout(new BorderLayout());
        JSplitPane botJPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.inventory, this.miniMap);
        botJPanel.setBorder(null);
        botJPanel.setDividerSize(0);
        botJPanel.setResizeWeight(1);
        this.add(this.mainMap, BorderLayout.WEST);
        this.add(this.sidebar, BorderLayout.EAST);
        this.add(botJPanel, BorderLayout.SOUTH);
        this.refToMainDisplay.getMainFrame().addKeyListener(keyboardAndMouseListener);
    }

    public Inventory getInventory()
    {
        return inventory;
    }

    public ClassicMainMap getMainMap()
    {
        return mainMap;
    }

    public MiniMap getMiniMap()
    {
        return miniMap;
    }


}
