package gamedatas;

/**
 * This is the "Frame" class, made to defined what is composing the map of the
 * game (which you just lost, by the way).
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @author WOERLY-MOUSSIER Joachim <joachim.woerly-moussier@iut-valence.fr>
 */
public enum Frame
{
    /* ---------------------- START DECLARATIONS---------------------- */

    /**
     * A wall. Nobody can walk on that.
     */
    WALL(false, false, "#", "W"),
    /**
     * The floor. Anybody can walk on it.
     */
    FLOOR(true, true, " ", "F"),
    /**
     * The Spies' floor. For spies only.
     */
    SPIESFLOOR(true, false, ".", "S"),
    /**
     * The Guards' floor. For guards only.
     */
    GUARDSFLOOR(false, true, "+", "G");

    /* ---------------------- END DECLARATIONS ---------------------- */
    /* ---------------------- START PARAMETERS DECLARATIONS ---------------------- */
    /**
     * is true if spies can walk on the frame
     */
    private final boolean spiesCanWalk;

    /**
     * is true if guards can walk on the frame
     */
    private final boolean guardsCanWalk;

    /**
     * text representation of the frame
     */
    private final String representation;

    private final String loadingRepresentation;

    /* ---------------------- END PARAMETERS DECLARATIONS ---------------------- */
    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    private Frame(boolean spies, boolean guards, String representation, String loadingRepresentation)
    {
        this.spiesCanWalk = spies;
        this.guardsCanWalk = guards;
        this.representation = representation;
        this.loadingRepresentation = loadingRepresentation;
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    @Override
    public String toString()
    {
        return this.representation;
    }

    public static Frame parseFrame(String string)
    {
        for (Frame value : Frame.values())
        {
            if (!value.loadingRepresentation.equals(string))
            {
            }
            else
            {
                return value;
            }
        }
        return null;

    }
    /* ---------------------- END FUNCTION(S) ---------------------- */

    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    /**
     * @return true if spies can walk on the frame
     */
    public boolean isWalkableBySpies()
    {
        return spiesCanWalk;
    }

    /**
     * @return true if guards can walk on the frame
     */
    public boolean isWalkableByGuards()
    {
        return guardsCanWalk;
    }
    /* ---------------------- END GETTERS AND SETTERS ---------------------- */
}
