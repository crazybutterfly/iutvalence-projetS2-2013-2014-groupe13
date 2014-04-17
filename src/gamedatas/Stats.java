/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gamedatas;

/**
 * a class where stats are defined.
 * @author WOERLY-MOUSSIER Joachim <joachim.woerly-moussier@iut-valence.fr>
 */
public class Stats {
    private int numberOfKills;
    private int timeSurvived;
    private int timesHandsGotOnTheDocs;
    private int remainingLives;
 
//TODO : DEFINE '+' OPERATOR

    /**
     * @return the remainingLives
     */
    public int getRemainingLives() 
    {
        return remainingLives;
    }
    /**
     * @param remainingLives the remainingLives to set
     */
    public void setRemainingLives(int remainingLives) 
    {
        this.remainingLives = remainingLives;
    }
    /**
     * @return the numberOfKills
     */
    public int getNumberOfKills() 
    {
        return numberOfKills;
    }

    /**
     * @param numberOfKills the numberOfKills to set
     */
    public void setNumberOfKills(int numberOfKills) 
    {
        this.numberOfKills = numberOfKills;
    }

    /**
     * @return the timeSurvived
     */
    public int getTimeSurvived() 
    {
        return timeSurvived;
    }

    /**
     * @param timeSurvived the timeSurvived to set
     */
    public void setTimeSurvived(int timeSurvived) 
    {
        this.timeSurvived = timeSurvived;
    }

    /**
     * @return the timesHandsGotOnTheDocs
     */
    public int getTimesHandsGotOnTheDocs() 
    {
        return timesHandsGotOnTheDocs;
    }

    /**
     * @param timesHandsGotOnTheDocs the timesHandsGotOnTheDocs to set
     */
    public void setTimesHandsGotOnTheDocs(int timesHandsGotOnTheDocs) 
    {
        this.timesHandsGotOnTheDocs = timesHandsGotOnTheDocs;
    }

}    