package display;

import gamedatas.AllPlayers;
import display.classicdisplay.ClassicStoreScreen;
import display.guardchiefdisplay.GuardChiefMainMap;
import display.classicdisplay.ClassicMainMap;
import gamedatas.Map;
import display.guardchiefdisplay.GuardChiefStoreScreen;
import gamedatas.Store;

public class MainDisplay
{

    public ClassicMainMap myClassicMainMap;
    public ClassicStoreScreen myClassicStoreScreen;
    public SideBar mySideBar;

    public MiniMap myMiniMap;
    public GuardChiefMainMap myGuardChiefMainMap;
    public GuardChiefStoreScreen myGuardChiefStoreScreen;

    public void refreshDisplay(Map myMap, Store stores, AllPlayers players)
    {
    }

    public void displayLastScreen()
    {
    }

}
