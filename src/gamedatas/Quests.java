package gamedatas;

/**
 * Class which contains the quest stats.
 *
 * @author DUBOIS Thomas <thomas.dubois@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @author BEGOT William <william.begot@iut-valence.fr>
 */
public class Quests
{
    /* ---------------------- START DECLARATIONS ---------------------- */

    /**
     * Si la quete est fini ou non.
     */
    protected boolean questFinished;

    /**
     * La quete est, par defaut, en cours.
     */
    protected boolean QUEST_FINISHED_DEFAULT = false;

    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public Quests()
    {
        this.questFinished = QUEST_FINISHED_DEFAULT;

    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */
}
