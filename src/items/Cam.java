package items;

public class Cam extends ItemOnTheMap
{

    /* ---------------------- START DECLARATIONS ---------------------- */
    public final int numCam;
    public static int numberOfCams;
    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    public Cam()
    {
        this.numCam = Cam.numberOfCams;
        Cam.numberOfCams++;
    }
    /* ---------------------- END FUNCTION(S) ---------------------- */
}
