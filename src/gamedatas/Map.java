package gamedatas;

import java.util.Vector;
import gamecore.Engine;


public class Map {

  public int numberOfColumns;

  public int numberOfLines;

    public Engine myEngine;
    /**
   * 
   * @element-type Case
   */
  public Case[][] map;
  public Map(int numberOfColumns, int numberOfLines)
  {this.numberOfColumns = numberOfColumns;
  this.numberOfLines = numberOfLines;
  this.map = new Case[this.numberOfColumns][this.numberOfLines];
  }
  /**
   * 
   * @element-type ItemOnTheMap
   */
  public Vector  myItemOnTheMap;

  public void createAWall(Integer xStartCase, Integer yStartCase, Integer xLarger, Integer yLarger) {
  }

  public void createAFloor(Integer xStartCase, Integer yStartCase, Integer xLarger, Integer yLarger, Boolean spiesCanWalk, Boolean guardsCanWalk) {
  }

}