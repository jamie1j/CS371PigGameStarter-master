package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    PigGameState game;
    /**
     * This ctor creates a new game state
     */

    public PigLocalGame() {
        //TODO  You will implement this constructor
        game = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if(game.getCurrID()==playerIdx){
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if(action instanceof PigRollAction){
            Random rand = new Random();
            game.setCurrDieValue(1+rand.nextInt(6));
            if(game.getCurrDieValue() > 1){
                game.setCurrPlayerRunningScore(game.getCurrPlayerRunningScore() + game.getCurrDieValue());
            } else {
                game.setCurrPlayerRunningScore(0);
                if(playerNames.length == 2) {
                    if (game.getCurrID() == 0) {
                        game.setCurrID(1);
                    } else {
                        game.setCurrID(0);
                    }
                }
            }

            return true;
        } else if(action instanceof PigHoldAction){
            if(game.getCurrID() == 0){
                game.setPlayer0Score(game.getPlayer0Score()+game.getCurrPlayerRunningScore());
                game.setCurrPlayerRunningScore(0);
            } else {
                game.setPlayer1Score(game.getPlayer1Score()+game.getCurrPlayerRunningScore());
                game.setCurrPlayerRunningScore(0);
            }

            if(playerNames.length == 2) {
                if (game.getCurrID() == 0) {
                    game.setCurrID(1);
                } else {
                    game.setCurrID(0);
                }
            }
            return true;
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState copyGame = new PigGameState(game);
        players[game.getCurrID()].sendInfo(copyGame);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(game.getPlayer0Score()>=50){
            return playerNames[0] + " won with a score of " + game.getPlayer0Score();
        } else if(game.getPlayer1Score()>=50){
            return playerNames[1] + " won with a score of " + game.getPlayer1Score();
        }
        return null;
    }

}// class PigLocalGame
