package gamedatas;

public class GuardQuest extends Quests
{
    /* ---------------------- START DECLARATIONS ---------------------- */

    /**
     * Variable définissant le nombre de kill effectué par un Guard sans mourir.
     */
    private int spyKilledWithoutDie;

    /**
     * Valeur par défaut du nombre de kill effectué par un Guard sans mourir.
     * Ici, cette valeur est de zéro.
     */
    public int SPY_KILLED_WITHOUT_DIE_DEFAULT = 0;

    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public GuardQuest()
    {
        super();
        this.spyKilledWithoutDie = SPY_KILLED_WITHOUT_DIE_DEFAULT;
    }

    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    /**
     * Fonction donnant un gain de Coins au GuarChiefPlayer lorsque qu'un Guard
     * tue un Spy. Plus le garde tue de Spies sans mourir, plus le gain est
     * important. Première kill : 100 Coins. Deuxième kill : 200 Coins. Etc.
     *
     * @param guardPlayer
     */
    public void guardHasKilledASpy(GuardChiefPlayer guardPlayer)
    {
        this.spyKilledWithoutDie += 1;
        guardPlayer.getGuardCoins().changeCoinQuantity(this.spyKilledWithoutDie * 100);
    }

    /**
     * Fonction réinitialisant le nombre de kill consécutive d'un Guard
     * lorsqu'il meurt.
     *
     * @param player
     */
    public void resetGuardNumberOfKills(GuardPlayer player)
    {
        this.spyKilledWithoutDie = SPY_KILLED_WITHOUT_DIE_DEFAULT;
    }
    /* ---------------------- END FUNCTION(S) ---------------------- */

}
