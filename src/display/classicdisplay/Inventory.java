package display.classicdisplay;

import display.MainDisplay;
import gamedatas.ClassicPlayer;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author MOREL Charles
 */
class Inventory extends JPanel implements ActionListener {

    /**
     * Reference to Main Display
     */
    private final MainDisplay refToMainDisplay;

    /**
     * Array composez of the buttons with represents items.
     */
    private JButton[] itemButtons;

    public Inventory(MainDisplay refToMainDisplay)
    {
        // Attributes initialization
        this.refToMainDisplay = refToMainDisplay;

        // Components initialization
        this.itemButtons = new JButton[ClassicPlayer.MAXIMUM_NUMBER_OF_ITEM_TYPE];
        for (int i = 0; i < ClassicPlayer.MAXIMUM_NUMBER_OF_ITEM_TYPE; i++)
        {
            this.itemButtons[i] = new JButton();
            this.itemButtons[i].setFocusable(false);
            this.itemButtons[i].addActionListener(this);
            this.add(this.itemButtons[i]);
        }
        refreshInventory();
    }

    @Override
    public void actionPerformed(ActionEvent actionSelected)
    {
        JButton selectedButton = (JButton) actionSelected.getSource();
        for (int i = 0; i < ClassicPlayer.MAXIMUM_NUMBER_OF_ITEM_TYPE; i++)
        {
            if (selectedButton == this.itemButtons[i])
            {
                if (this.refToMainDisplay.getPlayerSelected() < this.refToMainDisplay.getRefToGamePlayers().getNumberOfGuards())
                {
                    this.refToMainDisplay.getRefToGamePlayers().getGuardsArray()[this.refToMainDisplay.getPlayerSelected() - 1].setSelectedItemInInventory(i);
                }
                else
                {
                    this.refToMainDisplay.getRefToGamePlayers().getSpiesArray()[this.refToMainDisplay.getPlayerSelected() - this.refToMainDisplay.getRefToGamePlayers().getNumberOfGuards()].setSelectedItemInInventory(i);
                }
            }
            refreshInventory();
        }
    }

    public void refreshInventory()
    {
        for (int i = 0; i < ClassicPlayer.MAXIMUM_NUMBER_OF_ITEM_TYPE; i++)
        {
            if (this.refToMainDisplay.getPlayerSelected() < this.refToMainDisplay.getRefToGamePlayers().getNumberOfGuards())
            {
                this.itemButtons[i].setText(this.refToMainDisplay.getRefToGamePlayers().getGuardsArray()[this.refToMainDisplay.getPlayerSelected() - 1].getItems()[i].buttonText());
                if (i == this.refToMainDisplay.getRefToGamePlayers().getGuardsArray()[this.refToMainDisplay.getPlayerSelected() - 1].getSelectedItemInInventory())
                {
                    this.itemButtons[i].setBackground(Color.DARK_GRAY);
                    this.itemButtons[i].setForeground(Color.WHITE);
                }
                else
                {
                    this.itemButtons[i].setBackground(Color.WHITE);
                    this.itemButtons[i].setForeground(Color.BLACK);
                }

            }
            else
            {
                this.itemButtons[i].setText(this.refToMainDisplay.getRefToGamePlayers().getSpiesArray()[this.refToMainDisplay.getPlayerSelected() - this.refToMainDisplay.getRefToGamePlayers().getNumberOfGuards()].getItems()[i].buttonText());
                if (i == this.refToMainDisplay.getRefToGamePlayers().getSpiesArray()[this.refToMainDisplay.getPlayerSelected() - this.refToMainDisplay.getRefToGamePlayers().getNumberOfGuards()].getSelectedItemInInventory())
                {
                    this.itemButtons[i].setBackground(Color.DARK_GRAY);
                    this.itemButtons[i].setForeground(Color.WHITE);
                }
                else
                {
                    this.itemButtons[i].setBackground(Color.WHITE);
                    this.itemButtons[i].setForeground(Color.BLACK);
                }
            }
        }
    }

}
