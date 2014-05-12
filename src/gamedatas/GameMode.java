package gamedatas;

import items.Doc;

/**
 * Class which contains the game stats.
 *
 * @author DUBOIS Thomas <thomas.dubois@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @author BEGOT William <william.begot@iut-valence.fr>
 */
public class GameMode
{
    /* ---------------------- START DECLARATIONS ---------------------- */

    /**
     * the game status.
     */
    private GameStatus gameStatus;

    /**
     * Statistics of the times.
     */
    private Timer gameTimer;

    /**
     * Quests datas of the game.
     */
    private Quests[] gameQuests;
    
    /**
     * the doc on the map.
     */
    private Doc doc;
    
    /* ---------------------- END DECLARATIONS ---------------------- */

    public void GameMode()
    {
        
    }
    
    /**
     * getter for the doc.
     * @return the doc.
     */
    public Doc getDoc()
    {
        return this.doc;
    }
    
    /**
     * Places the doc.
     * @param posX the X position of the doc.
     * @param posY the Y position of the doc.
     */
    public void setDoc(int posX, int posY)
    {
        this.doc = new Doc(posX, posY);
    }
    
    
    public Quests[] getQuests()
    {
        return this.gameQuests;
    }
    
    public void setQuests(int posX, int posY, boolean isPrimary, int number, int priceWon, int teamPriceWon)
    {
        this.gameQuests[number] = new SpiesQuest(posX, posY, isPrimary, number, priceWon, teamPriceWon);
    }
}
