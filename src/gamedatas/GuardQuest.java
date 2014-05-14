package gamedatas;

public class GuardQuest extends Quests
{
    /* ---------------------- START DECLARATIONS ---------------------- */
    
    /**
     * Attribut définissant le nombre de Spies tués sans que le Guard ne meurt.
     */
    private int numberOfConsecutiveKillsWithoutDie;

    /**
     * Valeur par défaut du nombre de Spies tués sans que le Guard ne meurt.
     * Cette valeur est initialisée à 0.
     */
    public int NUMBER_OF_CONSECUTIVE_KILLS_WITHOUT_DIE_DEFAULT = 0;
   
    
    /* ---------------------- END DECLARATIONS ---------------------- */
    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    
    public GuardQuest()
    {
        super();
        numberOfConsecutiveKillsWithoutDie = NUMBER_OF_CONSECUTIVE_KILLS_WITHOUT_DIE_DEFAULT;
    }
    
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */
    
    /* ---------------------- START FUNCTION(S) ---------------------- */
    
    // Fonction ajoutant des Coins au GuardChief quand un Guard fait une série de kill sans mourir.
    // Il faut une fonction qui donne les Coins pour 3, 5, 7 kill consécutive.
    
    /* ---------------------- END FUNCTION(S) ---------------------- */

}
