package display.classicdisplay;

import display.MainDisplay;
import gamedatas.*;
import static gamedatas.Frame.FLOOR;
import static gamedatas.Frame.GUARDSFLOOR;
import static gamedatas.Frame.SPIESFLOOR;
import static gamedatas.Frame.WALL;
import java.awt.*;
import javax.swing.*;

public class ClassicMainMap extends JPanel {

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
     * the start colomn coordonne of the view.
     */
    private int startColumnNumberOfTheView;

    /**
     * the end colomn coordonne of the view.
     */
    private int endColumnNumberOfTheView;

    /**
     * the start line coordonne of the view.
     */
    private int startLineNumberOfTheView;

    /**
     * the end line coordonne of the view.
     */
    private int endLineNumberOfTheView;

    /**
     * The number of the columns visible by a Classic player.
     * WARNING: this number must be odd.
     */
    public final static int NUMBER_OF_COLUMNS_VISIBLE = 21;

    /**
     * The number of the lines visible by a Classic player.
     * WARNING: this number must be odd.
     */
    public final static int NUMBER_OF_LINES_VISIBLE = 21;

    /**
     * the player selection number in the JMenu.
     */
    private int selectedPlayer;

    public ClassicMainMap(MainDisplay refToMainDisplay)
    {
        // Attributs initialization:
        this.refToGameMap = refToMainDisplay.getRefToGameMap();
        this.refToAllPlayers = refToMainDisplay.getRefToGamePlayers();
        this.selectedPlayer = refToMainDisplay.getPlayerSelected();

        // layout:
        this.setLayout(new GridLayout(NUMBER_OF_COLUMNS_VISIBLE, NUMBER_OF_LINES_VISIBLE));
        this.mapFrame = new JPanel[NUMBER_OF_COLUMNS_VISIBLE][NUMBER_OF_LINES_VISIBLE];
        for (int i = 0; i < NUMBER_OF_LINES_VISIBLE; i++)
        {
            for (int j = 0; j < NUMBER_OF_COLUMNS_VISIBLE; j++)
            {
                this.mapFrame[i][j] = new JPanel();
                this.mapFrame[i][j].setPreferredSize(new Dimension(50, 50));
                this.mapFrame[i][j].setMinimumSize(new Dimension(50, 50));
                this.mapFrame[i][j].setMaximumSize(new Dimension(50, 50));
                this.mapFrame[i][j].setBorder(null);
                this.add(this.mapFrame[i][j]);
            }
        }
        refreshMainMap();
    }

    public void refreshMainMap()
    {
        updateViewCoordonnees();
        for (int i = this.startLineNumberOfTheView; i <= this.endLineNumberOfTheView; i++)
        {
            for (int j = this.startColumnNumberOfTheView; j <= this.endColumnNumberOfTheView; j++)
            {
                if (this.refToGameMap.getMap()[i][j] == WALL)
                {
                    this.mapFrame[i - this.startColumnNumberOfTheView + 1][j - this.startLineNumberOfTheView + 1].setBackground(Color.BLACK);
                }
                if (this.refToGameMap.getMap()[i][j] == FLOOR)
                {
                    this.mapFrame[i - this.startColumnNumberOfTheView + 1][j - this.startLineNumberOfTheView + 1].setBackground(Color.WHITE);
                }
                if (this.refToGameMap.getMap()[i - this.startColumnNumberOfTheView + 1][j - this.startLineNumberOfTheView + 1] == GUARDSFLOOR)
                {
                    this.mapFrame[i - this.startColumnNumberOfTheView + 1][j - this.startLineNumberOfTheView + 1].setBackground(Color.GRAY);
                }
                if (this.refToGameMap.getMap()[i - this.startColumnNumberOfTheView + 1][j - this.startLineNumberOfTheView + 1] == SPIESFLOOR)
                {
                    this.mapFrame[i - this.startColumnNumberOfTheView + 1][j - this.startLineNumberOfTheView + 1].setBackground(Color.LIGHT_GRAY);
                }
            }
        }

        for (int i = 0; i < this.refToAllPlayers.getNumberOfGuards() - 1; i++)
        {
            int teamPlayerXLocation = this.refToAllPlayers.getGuardsArray()[i].getPosX();
            int teamPlayerYLocation = this.refToAllPlayers.getGuardsArray()[i].getPosY();
            if (teamPlayerXLocation >= this.startLineNumberOfTheView && teamPlayerXLocation <= this.endLineNumberOfTheView && teamPlayerYLocation >= this.startColumnNumberOfTheView && teamPlayerYLocation <= this.endColumnNumberOfTheView)
            {
                this.mapFrame[teamPlayerXLocation - this.startColumnNumberOfTheView + 1][teamPlayerYLocation - this.startLineNumberOfTheView + 1].setBackground(Color.BLUE);
            }
        }


        for (int i = 0; i < this.refToAllPlayers.getNumberOfSpies(); i++)
        {
            int teamPlayerXLocation = this.refToAllPlayers.getSpiesArray()[i].getPosX();
            int teamPlayerYLocation = this.refToAllPlayers.getSpiesArray()[i].getPosY();
            if (teamPlayerXLocation >= this.startLineNumberOfTheView && teamPlayerXLocation <= this.endLineNumberOfTheView && teamPlayerYLocation >= this.startColumnNumberOfTheView && teamPlayerYLocation <= this.endColumnNumberOfTheView)
            {
                this.mapFrame[teamPlayerXLocation - this.startColumnNumberOfTheView + 1][teamPlayerYLocation - this.startLineNumberOfTheView + 1].setBackground(Color.RED);
            }
        }

    }


    private void updateViewCoordonnees()
    {
        int newStartColumnNumberOfTheView;
        int newStartLineNumberOfTheView;
        int newEndColumnNumberOfTheView;
        int newEndLineNumberOfTheView;
        if (this.selectedPlayer < this.refToAllPlayers.getNumberOfGuards())
        {
            newStartColumnNumberOfTheView = this.refToAllPlayers.getGuardsArray()[this.selectedPlayer - 1].getPosY() - ((NUMBER_OF_COLUMNS_VISIBLE - 1) / 2);
            newStartLineNumberOfTheView = this.refToAllPlayers.getGuardsArray()[this.selectedPlayer - 1].getPosX() - ((NUMBER_OF_LINES_VISIBLE - 1) / 2);
            newEndColumnNumberOfTheView = this.refToAllPlayers.getGuardsArray()[this.selectedPlayer - 1].getPosY() + ((NUMBER_OF_COLUMNS_VISIBLE - 1) / 2);
            newEndLineNumberOfTheView = this.refToAllPlayers.getGuardsArray()[this.selectedPlayer - 1].getPosX() + ((NUMBER_OF_LINES_VISIBLE - 1) / 2);
        }
        else
        {
            newStartColumnNumberOfTheView = this.refToAllPlayers.getSpiesArray()[this.selectedPlayer - this.refToAllPlayers.getNumberOfGuards()].getPosY() - ((NUMBER_OF_COLUMNS_VISIBLE - 1) / 2);
            newStartLineNumberOfTheView = this.refToAllPlayers.getSpiesArray()[this.selectedPlayer - this.refToAllPlayers.getNumberOfGuards()].getPosX() - ((NUMBER_OF_LINES_VISIBLE - 1) / 2);
            newEndColumnNumberOfTheView = this.refToAllPlayers.getSpiesArray()[this.selectedPlayer - this.refToAllPlayers.getNumberOfGuards()].getPosY() + ((NUMBER_OF_COLUMNS_VISIBLE - 1) / 2);
            newEndLineNumberOfTheView = this.refToAllPlayers.getSpiesArray()[this.selectedPlayer - this.refToAllPlayers.getNumberOfGuards()].getPosX() + ((NUMBER_OF_LINES_VISIBLE - 1) / 2);
        }

        if (newStartColumnNumberOfTheView < 0)
        {
            this.startColumnNumberOfTheView = 0;
            this.endColumnNumberOfTheView = NUMBER_OF_COLUMNS_VISIBLE - 1;
        }
        else
        {
            this.startColumnNumberOfTheView = newStartColumnNumberOfTheView;
        }

        if (newStartLineNumberOfTheView < 0)
        {
            this.startLineNumberOfTheView = 0;
            this.endLineNumberOfTheView = NUMBER_OF_LINES_VISIBLE - 1;
        }
        else
        {
            this.startLineNumberOfTheView = newStartLineNumberOfTheView;
        }

        if (newEndColumnNumberOfTheView >= this.refToGameMap.getNumberOfColumns())
        {
            this.endColumnNumberOfTheView = this.refToGameMap.getNumberOfColumns() - 1;
            this.startColumnNumberOfTheView = this.refToGameMap.getNumberOfColumns() - NUMBER_OF_COLUMNS_VISIBLE;
        }
        else
        {
            this.endColumnNumberOfTheView = newEndColumnNumberOfTheView;
        }

        if (newEndLineNumberOfTheView >= this.refToGameMap.getNumberOfLines())
        {
            this.endLineNumberOfTheView = this.refToGameMap.getNumberOfLines() - 1;
            this.startLineNumberOfTheView = this.refToGameMap.getNumberOfLines() - NUMBER_OF_LINES_VISIBLE;
        }
        else
        {
            this.endLineNumberOfTheView = newEndLineNumberOfTheView;
        }
    }

}
