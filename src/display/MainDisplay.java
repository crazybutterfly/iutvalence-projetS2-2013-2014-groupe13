package display;

import gamedatas.AllPlayers;
import display.classicdisplay.ClassicStoreScreen;
import display.guardchiefdisplay.GuardChiefMainMap;
import display.classicdisplay.ClassicMainMap;
import gamedatas.Store;
import gamedatas.ChatDatas;
import gamedatas.Map;
import display.guardchiefdisplay.GuardChiefStoreScreen;

public class MainDisplay {

    public ClassicMainMap myClassicMainMap;
    public ClassicStoreScreen myClassicStoreScreen;
    public SideBar mySideBar;
    public ChatDisplay myChatDisplay;
    public MiniMap myMiniMap;
    public GuardChiefMainMap myGuardChiefMainMap;
    public GuardChiefStoreScreen myGuardChiefStoreScreen;

  public void refreshDisplay(Map myMap, Store stores, ChatDatas chatInfos, AllPlayers players) {
  }

  public void displayLastScreen() {
  }

}