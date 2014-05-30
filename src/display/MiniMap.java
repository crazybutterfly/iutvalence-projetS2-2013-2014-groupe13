package display;

import gamedatas.*;
import static gamedatas.Frame.FLOOR;
import static gamedatas.Frame.GUARDSFLOOR;
import static gamedatas.Frame.SPIESFLOOR;
import static gamedatas.Frame.WALL;
import java.awt.*;
import javax.swing.*;

public class MiniMap extends JPanel {

    /**
     * Reference to game map
     */
    private Map refToGameMap;

    /**
     * Reference to all players
     */
    private AllPlayers refToAllPlayers;

    /**
     * JLabels who represents map Frames.
     */
    private JPanel[][] mapFrame;

    /**
     * the player selection number in the JMenu.
     */
    private int selectedPlayer;

    public MiniMap(MainDisplay refToMainDisplay)
    {
        // Attributs initialization:
        this.refToGameMap = refToMainDisplay.getRefToGameMap();
        this.refToAllPlayers = refToMainDisplay.getRefToGamePlayers();
        this.selectedPlayer = refToMainDisplay.getPlayerSelected();

        // layout:
        this.setLayout(new GridLayout(this.refToGameMap.getNumberOfColumns(), this.refToGameMap.getNumberOfLines()));
        this.mapFrame = new JPanel[this.refToGameMap.getNumberOfColumns()][this.refToGameMap.getNumberOfLines()];
        for (int i = 0; i < this.refToGameMap.getNumberOfLines(); i++)
        {
            for (int j = 0; j < this.refToGameMap.getNumberOfColumns(); j++)
            {
                this.mapFrame[j][i] = new JPanel();
                this.mapFrame[j][i].setPreferredSize(new Dimension(2, 2));
                this.mapFrame[j][i].setMinimumSize(new Dimension(2, 2));
                this.mapFrame[j][i].setMaximumSize(new Dimension(2, 2));
                this.mapFrame[j][i].setBorder(null);
                this.add(this.mapFrame[j][i]);
            }
        }
        refreshMiniMap();
    }

    public void refreshMiniMap()
    {
        for (int i = 0; i < this.refToGameMap.getNumberOfLines(); i++)
        {
            for (int j = 0; j < this.refToGameMap.getNumberOfColumns(); j++)
            {
                if (this.refToGameMap.getMap()[j][i] == WALL)
                {
                    this.mapFrame[j][i].setBackground(Color.BLACK);
                }
                if (this.refToGameMap.getMap()[j][i] == FLOOR)
                {
                    this.mapFrame[j][i].setBackground(Color.WHITE);
                }
                if (this.refToGameMap.getMap()[j][i] == GUARDSFLOOR)
                {
                    this.mapFrame[j][i].setBackground(Color.GRAY);
                }
                if (this.refToGameMap.getMap()[j][i] == SPIESFLOOR)
                {
                    this.mapFrame[j][i].setBackground(Color.LIGHT_GRAY);
                }
            }
        }
        if (this.selectedPlayer < this.refToAllPlayers.getNumberOfGuards())
        {
            for (int i = 0; i < this.refToAllPlayers.getNumberOfGuards() - 1; i++)
            {
                int teamPlayerXLocation = this.refToAllPlayers.getGuardsArray()[i].getPosX();
                int teamPlayerYLocation = this.refToAllPlayers.getGuardsArray()[i].getPosY();
                this.mapFrame[teamPlayerXLocation][teamPlayerYLocation].setBackground(Color.BLUE);
            }
        }
        else
        {
            for (int i = 0; i < this.refToAllPlayers.getNumberOfSpies(); i++)
            {
                int teamPlayerXLocation = this.refToAllPlayers.getSpiesArray()[i].getPosX();
                int teamPlayerYLocation = this.refToAllPlayers.getSpiesArray()[i].getPosY();
                this.mapFrame[teamPlayerXLocation][teamPlayerYLocation].setBackground(Color.RED);
            }
        }
    }

}
