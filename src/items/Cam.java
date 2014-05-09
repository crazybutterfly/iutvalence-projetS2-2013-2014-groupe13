package items;

public class Cam extends ItemOnTheMap
{

    /* ---------------------- START DECLARATIONS ---------------------- */
    private final int numCam;
    private CamStatus camStatus;
    private final static int PRICE = 100;
    private final static int TIME_BEFORE_UNLOCK = 0;
    private final static boolean USABLE_BY_SPY = false;
    private final static boolean USABLE_BY_GUARD = false;

    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */

    /**
     *
     * @param camID
     * @param posX
     * @param posY
     */
    
    public Cam(int camID, int posX, int posY)
    {
        super("Cam", Cam.USABLE_BY_SPY, Cam.USABLE_BY_GUARD, Cam.TIME_BEFORE_UNLOCK, Cam.PRICE, posX, posY);
        this.numCam = camID;
        this.camStatus = CamStatus.WORKING;
        this.isOnMapYet = true;


    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    
    
    /* ---------------------- END FUNCTION(S) ---------------------- */

    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    /**
     * @return the number of the cam
     */
    public int getNumCam()
    {
        return numCam;
    }
    
    /**
     * getter for the cam status.
     * @return the status of the cam.
     */
    public CamStatus getCamStatus()
    {
        return this.camStatus;
    }
    
    /**
     * setter for the cam status.
     * @param status
     */
    public void setCamStatus(CamStatus status)
    {
        this.camStatus = status;
    }
    /* ---------------------- END GETTERS AND SETTERS ---------------------- */
}
