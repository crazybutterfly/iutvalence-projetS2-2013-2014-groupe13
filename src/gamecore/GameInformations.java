package gamecore;

import display.InitialParametersInput;
import javax.swing.SwingUtilities;

/**
 * Game informations used to initialise the game engine.
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public class GameInformations {

    /* ---------------------- START DECLARATIONS ---------------------- */
    /**
     * the number of guards for this game (guard chief include).
     */
    private int numberOfGuards;

    /**
     * the nuber of spies for this game.
     */
    private int numberOfSpies;

    /**
     * the map location.
     */
    private String mapLocation;

    /**
     * the quests location.
     */
    private String questsLocation;

    /**
     * the Frame used to enter game informations.
     */
    private final InitialParametersInput InputFrame;

    /**
     * the default number of guards for a game.
     */
    public static final int NUMBER_OF_GUARDS_DEFAULT = 2;

    /**
     * the default number of spies for a game.
     */
    public static final int NUMBER_OF_SPIES_DEFAULT = 2;
    /* ---------------------- END DECLARATIONS ---------------------- */


    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public GameInformations() {
        this.numberOfGuards = NUMBER_OF_GUARDS_DEFAULT;
        this.numberOfSpies = NUMBER_OF_SPIES_DEFAULT;
        this.InputFrame = new InitialParametersInput(this);
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    public void setParameters() {
        SwingUtilities.invokeLater(this.InputFrame);
        int i = 0;
        while (!this.InputFrame.isInputFinish()) {
            System.out.println(i++);
        }
    }
    /* ---------------------- END FUNCTION(S) ---------------------- */

    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    /**
     * @return the numberOfGuards
     */
    public int getNumberOfGuards() {
        return numberOfGuards;
    }

    /**
     * @param numberOfGuards the numberOfGuards to set
     */
    public void setNumberOfGuards(int numberOfGuards) {
        this.numberOfGuards = numberOfGuards;
    }

    /**
     * @return the numberOfSpies
     */
    public int getNumberOfSpies() {
        return numberOfSpies;
    }

    /**
     * @param numberOfSpies the numberOfSpies to set
     */
    public void setNumberOfSpies(int numberOfSpies) {
        this.numberOfSpies = numberOfSpies;
    }

    /* ---------------------- END GETTERS AND SETTERS ---------------------- */
    /**
     * @return the mapLocation
     */
    public String getMapLocation() {
        return mapLocation;
    }

    /**
     * @param mapLocation the mapLocation to set
     */
    public void setMapLocation(String mapLocation) {
        this.mapLocation = mapLocation;
    }

    /**
     * @return the questsLocation
     */
    public String getQuestsLocation() {
        return questsLocation;
    }

    /**
     * @param questsLocation the questsLocation to set
     */
    public void setQuestsLocation(String questsLocation) {
        this.questsLocation = questsLocation;
    }
}
