package gamecore;

import gamedatas.AllPlayers;
import playersinteractions.PlayerInputs;
import gamedatas.Store;
import display.MainDisplay;
import gamedatas.ChatDatas;
import gamedatas.GameMode;
import gamedatas.Map;

/**
 * Game Engine. Primordial class used during the game, process cycles for
 * players etc.
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public class Engine
{

    /* ---------------------- START DECLARATIONS ---------------------- */
    /**
     * The number of players in the game
     */
    public int numberOfPlayer;

    /**
     * IHM used to display the game for the player.
     */
    public MainDisplay mainDisplay;

    /**
     * All players informations.
     */
    public AllPlayers allPlayers;

    /**
     * All chat datas (not used).
     */
    public ChatDatas chatDatas;

    /**
     * Datas of the different quests of the game.
     */
    public GameMode myGameMode;

    /**
     * All Map datas.
     */
    public Map map;

    /**
     * All store datas.
     */
    public Store store;

    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public void Engine(GameInformations gameInfos)
    {

    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    public void doInteraction(PlayerInputs playerInput)
    {
    }

    public void classicPlayerPlay()
    {
    }

    public void classicPlayerWaitingRespawn()
    {
    }

    public void classicPlayerDead()
    {
    }

    public void startCycle()
    {
    }
    /* ---------------------- END FUNCTION(S) ---------------------- */

    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    /* ---------------------- END GETTERS AND SETTERS ---------------------- */
}
