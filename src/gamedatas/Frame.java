package gamedatas;

/**
 * This is the frame class, made to defined what is composing the map of 
 * the game (which you just lost, by the way).
 * @author WOERLY-MOUSSIER Joachim <joachim.woerly-moussier@iut-valence.fr>
 */
public class Frame {

    /**
     * is the content of that frame a wall ?
     */
    private boolean isAWall;
    
    /**
     * can spies walk on that ?
     */
    private boolean spiesCanWalk;

    /**
     * can guards walk on that ?
     */
    private boolean guardsCanWalk;
    
    
    public Frame (){
        
        this.isAWall=true;
        this.spiesCanWalk=false;
        this.guardsCanWalk=false;
        
    }
    
    /**
     * @return IsAWall
     */

    public boolean GetIsAWall(){
        return this.isAWall;
    }
    
    /**
     * @return spiesCanWalk
     */
    
    public boolean GetSpiesCanWalk() {
        return spiesCanWalk;
    }

    /**
     * @return guardsCanWalk
     */
    public boolean GetGuardsCanWalk() {
        return guardsCanWalk;
    }

}
