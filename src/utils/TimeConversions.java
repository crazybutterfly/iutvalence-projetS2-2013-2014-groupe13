package utils;

import java.util.Date;

/**
 * Class used to do time conversions. This is a system class (just composed of
 * functions)
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public class TimeConversions
{
    /* ---------------------- START FUNCTION(S) ---------------------- */

    /**
     * Convert a time in milliseconds to a time in seconds.
     *
     * @param timeToConvert time to convert in milliseconds (long)
     *
     * @return the time converted in seconds (float)
     */
    public float convertMillisecondsToSeconds(long timeToConvert)
    {
        long timeConvertedInSeconds;

        timeConvertedInSeconds = timeToConvert;
        timeConvertedInSeconds /= 1000;

        return timeConvertedInSeconds;
    }

    public Date convertMillisecondsToJavaDate(long timeToConvert)
    {
        return new Date(timeToConvert);
    }

}
