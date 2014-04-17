package items;


public class Cam extends ItemOnTheMap {
  public final int numCam;

  public static int numberOfCams;

  
  public Cam()
  {
      this.numCam = Cam.numberOfCams;
      Cam.numberOfCams ++;
  }
}