package gamedatas;

/**
 * This is the "case" class, made to defined what is composing the map of 
 * the game (which you just lost, by the way).
 * @author UCDP_Brony
 */
public class Case {

    /**
     * is the content of that case a wall ?
     */
    public boolean IsAWall;

    /**
     * can spies walk on that ?
     */
    public boolean spiesCanWalk;

    /**
     * can guards walk on that ?
     */
    public boolean guardsCanWalk;

    /**
     * this is the map of the building.
     */
    public Map myMap;

}