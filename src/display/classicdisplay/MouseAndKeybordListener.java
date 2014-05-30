package display.classicdisplay;

import display.MainDisplay;
import java.awt.event.*;

/**
 *
 * @author MOREL Charles
 */
public class MouseAndKeybordListener implements MouseListener, KeyListener {

    /**
     * reference to MainDisplay
     */
    private MainDisplay refToMainDisplay;

    MouseAndKeybordListener(MainDisplay refToMainDisplay)
    {
        this.refToMainDisplay = refToMainDisplay;
    }

    @Override
    public void mouseClicked(MouseEvent event)
    {
        if (event.getButton() == MouseEvent.BUTTON1)
        {
            if (this.refToMainDisplay.getPlayerSelected() < this.refToMainDisplay.getRefToGamePlayers().getNumberOfGuards())
            {
                this.refToMainDisplay.getRefToGamePlayers().getGuardsArray()[this.refToMainDisplay.getPlayerSelected() - 1].useSelectedItem();
            }
            else
            {
                this.refToMainDisplay.getRefToGamePlayers().getSpiesArray()[this.refToMainDisplay.getPlayerSelected() - this.refToMainDisplay.getRefToGamePlayers().getNumberOfGuards()].useSelectedItem();
            }
        }
        else
        {
            if (this.refToMainDisplay.getPlayerSelected() < this.refToMainDisplay.getRefToGamePlayers().getNumberOfGuards() && this.refToMainDisplay.getRefToGamePlayers().getGuardsArray()[this.refToMainDisplay.getPlayerSelected() - 1].getSelectedItemInInventory() == 0)
            {
                this.refToMainDisplay.getRefToGamePlayers().getGuardsArray()[this.refToMainDisplay.getPlayerSelected() - 1].getItems()[0].reload();
            }
        }
        this.refToMainDisplay.getCurrentJPanel().getInventory().refreshInventory();
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }

    @Override
    public void keyTyped(KeyEvent event)
    {
        if (event.getKeyChar() == 'z')
        {
            if (this.refToMainDisplay.getPlayerSelected() < this.refToMainDisplay.getRefToGamePlayers().getNumberOfGuards())
            {
                this.refToMainDisplay.getRefToGamePlayers().getGuardsArray()[this.refToMainDisplay.getPlayerSelected() - 1].getCurrentMoves().moveUp();
            }
            else
            {
                this.refToMainDisplay.getRefToGamePlayers().getSpiesArray()[this.refToMainDisplay.getPlayerSelected() - this.refToMainDisplay.getRefToGamePlayers().getNumberOfGuards()].getCurrentMoves().moveUp();
            }
        }
        if (event.getKeyChar() == 'q')
        {
            if (this.refToMainDisplay.getPlayerSelected() < this.refToMainDisplay.getRefToGamePlayers().getNumberOfGuards())
            {
                this.refToMainDisplay.getRefToGamePlayers().getGuardsArray()[this.refToMainDisplay.getPlayerSelected() - 1].getCurrentMoves().moveLeft();
            }
            else
            {
                this.refToMainDisplay.getRefToGamePlayers().getSpiesArray()[this.refToMainDisplay.getPlayerSelected() - this.refToMainDisplay.getRefToGamePlayers().getNumberOfGuards()].getCurrentMoves().moveLeft();
            }
        }
        if (event.getKeyChar() == 's')
        {
            if (this.refToMainDisplay.getPlayerSelected() < this.refToMainDisplay.getRefToGamePlayers().getNumberOfGuards())
            {
                this.refToMainDisplay.getRefToGamePlayers().getGuardsArray()[this.refToMainDisplay.getPlayerSelected() - 1].getCurrentMoves().moveDown();
            }
            else
            {
                this.refToMainDisplay.getRefToGamePlayers().getSpiesArray()[this.refToMainDisplay.getPlayerSelected() - this.refToMainDisplay.getRefToGamePlayers().getNumberOfGuards()].getCurrentMoves().moveDown();
            }
        }
        if (event.getKeyChar() == 'd')
        {
            if (this.refToMainDisplay.getPlayerSelected() < this.refToMainDisplay.getRefToGamePlayers().getNumberOfGuards())
            {
                this.refToMainDisplay.getRefToGamePlayers().getGuardsArray()[this.refToMainDisplay.getPlayerSelected() - 1].getCurrentMoves().moveRight();
            }
            else
            {
                this.refToMainDisplay.getRefToGamePlayers().getSpiesArray()[this.refToMainDisplay.getPlayerSelected() - this.refToMainDisplay.getRefToGamePlayers().getNumberOfGuards()].getCurrentMoves().moveRight();
            }
        }
//        this.refToMainDisplay.getCurrentJPanel().getMainMap().refreshMainMap();
        this.refToMainDisplay.getCurrentJPanel().getMiniMap().refreshMiniMap();

    }

    @Override
    public void keyPressed(KeyEvent event)
    {
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }

}
