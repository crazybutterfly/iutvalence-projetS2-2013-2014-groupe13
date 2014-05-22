package gamedatas;

/**
 * Class with represents players moves on the map.
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public abstract class ClassicPlayerMoves
{
    /* ---------------------- START DECLARATIONS ---------------------- */


    /**
     * Vitesse du joueur sur l'axe X.
     */
    protected int xPlayerSpeed;

    /**
     * Vitesse du joueur sur l'axe Y.
     */
    protected int yPlayerSpeed;
    
    protected ClassicPlayer player;


    /**
     * Valeur par défaut de la vitesse du joueur en fonction de l'axe X.
     */
    public final static int X_PLAYER_SPEED_DEFAULT = 0;

    /**
     * Valeur par défaut de la vitesse du joueur en fonction de l'axe Y.
     */
    public final static int Y_PLAYER_SPEED_DEFAULT = 0;
    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public ClassicPlayerMoves(ClassicPlayer player)
    {
        this.xPlayerSpeed = ClassicPlayerMoves.X_PLAYER_SPEED_DEFAULT;
        this.yPlayerSpeed = ClassicPlayerMoves.Y_PLAYER_SPEED_DEFAULT;
        this.player = player;
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    public abstract void moveUp();

    
    public abstract void moveDown();
    
    public abstract void moveLeft();
   
    public abstract void moveRight();
    
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */
    /* ---------------------- START GETTERS & SETTERS ---------------------- */

    /* ---------------------- END GETTERS AND SETTERS ---------------------- */
}
