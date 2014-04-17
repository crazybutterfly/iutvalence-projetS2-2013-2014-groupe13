package gamecore;

import gamedatas.AllPlayers;
import playersinteractions.PlayerInputs;
import gamedatas.DataInterface;
import java.util.Vector;
import gamedatas.Store;
import display.MainDisplay;
import gamedatas.ChatDatas;
import gamedatas.Map;


public class Engine {

  // public [WHAT TYPE ?] Team;

  public int numberOfPlayer;

    public MainDisplay mainDisplay;
    public AllPlayers allPlayers;
    public ChatDatas chatDatas;
    /**
   * 
   * @element-type GameMode
   */
  public Vector  myGameMode;
    public DataInterface dataInterface;
    public GameLauncher gameLauncher;
    public Map map;
    public Store store;

  public void doInteraction(PlayerInputs playerInput) {
  }

  public void Engine(GameInformations gameInfos) {
  }

  public void classicPlayerPlay() {
  }

  public void classicPlayerWaitingRespawn() {
  }

  public void classicPlayerDead() {
  }

  public void startCycle() {
  }

}