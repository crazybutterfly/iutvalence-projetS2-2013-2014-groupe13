package gamedatas;

import items.Doc;

/**
 * Class which contains the game stats.
 *
 * @author DUBOIS Thomas <thomas.dubois@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @author BEGOT William <william.begot@iut-valence.fr>
 */
public class GameMode {
    /* ---------------------- START DECLARATIONS ---------------------- */

    /**
     * the game status.
     */
    private GameStatus gameStatus;

    /**
     * Statistics of the times.
     */
    private Timer gameTimer = new Timer();

    /**
     * Quests datas of the game.
     */
    private SpiesQuest[] gameQuests;

    /**
     * the doc on the map.
     */
    private Doc doc;

    private int spiesRespawnPointPosX;

    private int spiesRespawnPointPosY;

    private int guardsRespawnPointPosX;

    private int guardsRespawnPointPosY;


    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public GameMode()
    {

    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */

    /**
     * Places the doc.
     *
     * @param posX the X position of the doc.
     * @param posY the Y position of the doc.
     */
    public void setDoc(int posX, int posY)
    {
        this.doc = new Doc(posX, posY);
    }

    public void setNumberOfQuests(int numberOfQuests)
    {
        this.gameQuests = new SpiesQuest[numberOfQuests];
    }


    public SpiesQuest getQuests(int index)
    {
        return this.gameQuests[index];
    }

    public void setQuests(int posX, int posY, boolean isPrimary, int number, int priceWon, int teamPriceWon)
    {
        this.gameQuests[number] = new SpiesQuest(posX, posY, isPrimary, priceWon, teamPriceWon);
    }

    public void setTimer(int time)
    {
        this.gameTimer.setMaxGameTime(time);
    }
    /* ---------------------- END FUNCTION(S) ---------------------- */

    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    /**
     * getter for the doc.
     *
     * @return the doc.
     */
    public Doc getDoc()
    {
        return this.doc;
    }
    /* ---------------------- END GETTERS AND SETTERS ---------------------- */

    public void setSpiesRespawnPoint(int spyRespawnPosX, int spyRespawnPosY)
    {
        this.spiesRespawnPointPosX = spyRespawnPosX;
        this.spiesRespawnPointPosY = spyRespawnPosY;
    }

    public void setGuardsRespawnPoint(int guardsRespawnPosX, int guardsRespawnPosY)
    {
        this.guardsRespawnPointPosX = guardsRespawnPosX;
        this.guardsRespawnPointPosY = guardsRespawnPosY;
    }

    public int getSpyRespawnPointPosX()
    {
        return this.spiesRespawnPointPosX;
    }

    public int getSpyRespawnPointPosY()
    {
        return this.spiesRespawnPointPosY;
    }

    public int getGuardRespawnPointPosX()
    {
        return this.guardsRespawnPointPosX;
    }

    public int getGuardRespawnPointPosY()
    {
        return this.guardsRespawnPointPosY;
    }

}
