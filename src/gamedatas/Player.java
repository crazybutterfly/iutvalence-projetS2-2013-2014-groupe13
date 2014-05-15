package gamedatas;

/**
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author DUBOIS Thomas <thomas.dubois@iut-valence.fr>
 */
public class Player
{
    /* ---------------------- START DECLARATIONS ---------------------- */

    /**
     * Attribut attribuant un pseudo à un joueur.
     */
    protected String pseudo;

    /**
     * Référence vers la map.
     */
    protected Map currentMap;

    /**
     * Pseudo par défaut d'un joueur.
     */
    public final static String DEFAULT_PSEUDO_PREFIX = "PLAYER";
    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public Player(Map mapRef)
    {
        this.currentMap = mapRef;
        this.pseudo = Player.DEFAULT_PSEUDO_PREFIX;
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    public boolean changePseudo(String[] allPlayersPseudos, String newPseudo)
    {
        for (String allPlayersPseudo : allPlayersPseudos) {
            if (allPlayersPseudo.equals(newPseudo)) {
                return false;
            }
        }
        this.pseudo = newPseudo;
        return true;
    }
    /* ---------------------- END FUNCTION(S) ---------------------- */
    /* ---------------------- START GETTERS & SETTERS ---------------------- */

    /**
     * @return the pseudo
     */
    public String getPseudo()
    {
        return pseudo;
    }
    /* ---------------------- END GETTERS AND SETTERS ---------------------- */

}
