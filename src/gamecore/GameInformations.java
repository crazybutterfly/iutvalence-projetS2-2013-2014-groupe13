package gamecore;

/**
 * Game informations used to initialise the game engine.
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public class GameInformations
{

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
     * the default number of guards for a game.
     */
    public static final int NUMBER_OF_GUARDS_DEFAULMT = 2;

    /**
     * the default number of spies for a game.
     */
    public static final int NUMBER_OF_SPIES_DEFAULT = 2;
    /* ---------------------- END DECLARATIONS ---------------------- */


    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public GameInformations()
    {
        this.numberOfGuards = NUMBER_OF_GUARDS_DEFAULMT;
        this.numberOfSpies = NUMBER_OF_SPIES_DEFAULT;
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    /* ---------------------- END FUNCTION(S) ---------------------- */

    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    /**
     * @return the numberOfGuards
     */
    public int getNumberOfGuards()
    {
        return numberOfGuards;
    }

    /**
     * @param numberOfGuards the numberOfGuards to set
     */
    public void setNumberOfGuards(int numberOfGuards)
    {
        this.numberOfGuards = numberOfGuards;
    }

    /**
     * @return the numberOfSpies
     */
    public int getNumberOfSpies()
    {
        return numberOfSpies;
    }

    /**
     * @param numberOfSpies the numberOfSpies to set
     */
    public void setNumberOfSpies(int numberOfSpies)
    {
        this.numberOfSpies = numberOfSpies;
    }

    /* ---------------------- END GETTERS AND SETTERS ---------------------- */
}
