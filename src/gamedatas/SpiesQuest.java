package gamedatas;

public class SpiesQuest extends Quests {

    /* ---------------------- START DECLARATIONS ---------------------- */
    /**
     * Position X de la Quest.
     */
    private int posX;

    /**
     * Position Y de la Quest.
     */
    private int posY;

    /**
     * Booléen définissant si une quete est terminée ou non.
     */
    private boolean questIsDone;

    /**
     * Booléen définissant si une quete est principale ou secondaire.
     */
    private boolean questIsPrimaryQuest;

    /**
     * Argent gagné par le joueur atteignant un checkpoint.
     */
    private final int priceWonIfQuestDone;

    /**
     * Argent gagné par l'équipe lorsque qu'un joueur atteint un checkpoint.
     */
    private final int teamPriceIfQuestDone;

    /**
     * Valeur par défaut de l'accomplissement de la quete. Par défaut, elle
     * n'est pas terminée.
     */
    private boolean QUEST_IS_DONE_DEFAULT = false;

    /**
     * Valeur par défaut de l'argent gagné par le joueur quand il atteint un
     * checkpoint.
     */
    private int PRICE_WON_IF_CHECKPOINT_QUEST_DONE_DEFAULT = 200;

    /**
     * Valeur par défaut de l'argent gagné par l'équipe lorsque qu'un joueur
     * atteint un checkpoint.
     */
    private int TEAM_PRICE_IF_CHECKPOINT_QUEST_DONE = 300;

    /* ---------------------- END DECLARATIONS ---------------------- */
    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    /**
     *
     * @param posX                 Position X de la quete.
     * @param posY                 Position Y de la quete.
     * @param questIsPrimaryQuest  Quete primaire ou secondaire.
     * @param priceWonIfQuestDone  Argent gagné par le joueur.
     * @param teamPriceIfQuestDone Argent gagné par l'équipe.
     */
    public SpiesQuest(int posX, int posY, boolean questIsPrimaryQuest, int priceWonIfQuestDone, int teamPriceIfQuestDone)
    {
        this.posX = posX;
        this.posY = posY;
        this.questIsPrimaryQuest = questIsPrimaryQuest;
        this.priceWonIfQuestDone = priceWonIfQuestDone;
        this.teamPriceIfQuestDone = teamPriceIfQuestDone;
    }

    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */
    /* ---------------------- START FUNCTION(S) ---------------------- */
    /**
     * Fonction mettant fin à une checkpointQuest et donnant de l'argent à
     * l'équipe des Spies avec un supplément pour le joueur ayant atteint le
     * checkpoint.
     *
     * @param spiesArray Tableau de Spies.
     */
    public void checkpointQuest(SpyPlayer[] spiesArray)
    {
        for (int i = 0; i < spiesArray.length; i++)
        {
            if (spiesArray[i].getPosX() == this.posX && spiesArray[i].getPosY() == this.posY)
            {
                this.questIsDone = true;
                spiesArray[i].getMyCoins().changeCoinQuantity(this.priceWonIfQuestDone);
                for (int index = 0; index < spiesArray.length; index++)
                {
                    spiesArray[index].getMyCoins().changeCoinQuantity(this.teamPriceIfQuestDone);
                }
            }
        }
    }

    /* ---------------------- END FUNCTION(S) ---------------------- */

    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    public int getPosX()
    {
        return this.posX;
    }

    public int getPosY()
    {
        return this.posY;
    }
    /* ---------------------- END GETTERS AND SETTERS ---------------------- */

}
