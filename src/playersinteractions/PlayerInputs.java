package playersinteractions;

/**
 * Class which intercept players inputs.
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public class PlayerInputs
{

    /**
     * last character ou key imput by the player.
     */
    public String lastKeyboardInput;

    /**
     * mouse cursor X-position at last interaction .
     */
    public int mouseCursorPosX;

    /**
     * mouse cursor Y-position at last interaction .
     */
    public int mouseCursorPosY;

    /**
     * mouse key pressed at last leyboard interaction.
     */
    public String lastMouseInput;

    /**
     * player has asked an interaction using keyboard.
     */
    public boolean interactionByKeyboard;

    /**
     * player has asked an interaction using mouse.
     */
    public boolean interactionByMouse;

}
