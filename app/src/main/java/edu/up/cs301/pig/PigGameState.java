package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by vennes19 on 2/24/2016.
 */
public class PigGameState extends GameState {
    private int currID;
    private int player0Score;
    private int player1Score;
    private int currPlayerRunningScore;
    private int currDieValue;

    public PigGameState() {
        super();

        currID = 0;
        player0Score = 0;
        player1Score = 0;
        currPlayerRunningScore = 0;
        currDieValue = 0;
    }

    public PigGameState(PigGameState aGameState) {
        this.setCurrID(aGameState.getCurrID());
        this.setPlayer0Score(aGameState.getPlayer0Score());
        this.setPlayer1Score(aGameState.getPlayer1Score());
        this.setCurrDieValue(aGameState.getCurrDieValue());
        this.setCurrPlayerRunningScore(aGameState.getCurrPlayerRunningScore());
    }

    public int getCurrID() {
        return currID;
    }
    public int getPlayer0Score() {
        return player0Score;
    }
    public int getPlayer1Score() {
        return player1Score;
    }
    public int getCurrPlayerRunningScore() {
        return currPlayerRunningScore;
    }
    public int getCurrDieValue() {
        return currDieValue;
    }

    public void setCurrID(int anID) {
        currID = anID;
    }
    public void setPlayer0Score(int aPlayer0Score) {
        player0Score = aPlayer0Score;
    }
    public void setPlayer1Score(int aPlayer1Score) {
        player1Score = aPlayer1Score;
    }
    public void setCurrPlayerRunningScore(int aCurrPlayerRunningScore) {
        currPlayerRunningScore = aCurrPlayerRunningScore;
    }
    public void setCurrDieValue(int aCurrDieValue) {
        currDieValue = aCurrDieValue;
    }
}
