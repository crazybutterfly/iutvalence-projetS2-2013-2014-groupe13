package items;

public class Cam extends ItemOnTheMap
{

    /* ---------------------- START DECLARATIONS ---------------------- */
    private final int numCam;

    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public Cam(int camID)
    {
        this.numCam = camID;
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    /* ---------------------- END FUNCTION(S) ---------------------- */

    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    /**
     * @return the numCam
     */
    public int getNumCam()
    {
        return numCam;
    }
    /* ---------------------- END GETTERS AND SETTERS ---------------------- */
}
