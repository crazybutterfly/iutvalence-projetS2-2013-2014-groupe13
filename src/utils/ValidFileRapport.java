package utils;

/**
 * Class who represents a map rapport from GameInofrmationsLoaderFromFile.isMapFileValid
 * @author MOREL Charles
 */
public class ValidFileRapport {
    
    /**
     * is map file valid?
     */
    public boolean fileIsValid;
    
    /**
     * rapport for invalid file.
     */
    public String invalidFilerapport;
    
    public ValidFileRapport()
    {
        this.fileIsValid = false;
        this.invalidFilerapport = "";
    }
}
