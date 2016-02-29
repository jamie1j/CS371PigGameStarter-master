package edu.up.cs301.pig;

import android.util.Log;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.infoMsg.GameState;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        PigGameState theGame;
            if(info instanceof GameState){
                theGame = (PigGameState) info;
            } else {
                return;
        }

//        int compId;
//        if (this.name == this.allPlayerNames[0]) {
//            compId = 0;
//        }
//        else {
//            compId = 1;
//        }
        if(theGame.getCurrID() == playerNum) {
//            if(theGame.getCurrPlayerRunningScore() < 10){
//                PigRollAction action = new PigRollAction(this);
//                game.sendAction(action);
//                return;
//            }
//            int diff = Math.abs(theGame.getPlayer0Score() - theGame.getPlayer1Score());
//            Log.i("test"+diff,"");
//            if(diff>=10 && diff<20){
//                if(theGame.getPlayer0Score()>theGame.getPlayer1Score() && playerNum == 1){
//                    if(theGame.getCurrPlayerRunningScore() < 15){
//                        PigRollAction action = new PigRollAction(this);
//                        game.sendAction(action);
//                        return;
//                    }
//                }
//                if(theGame.getPlayer0Score()<theGame.getPlayer1Score() && playerNum == 0){
//                    if(theGame.getCurrPlayerRunningScore() < 15){
//                        PigRollAction action = new PigRollAction(this);
//                        game.sendAction(action);
//                        return;
//                    }
//                }
//            }


//            if(theGame.getCurrPlayerRunningScore() < 10){
//                Log.i("test", theGame.getCurrPlayerRunningScore()+"");
//                PigRollAction action = new PigRollAction(this);
//                game.sendAction(action);
//                return;
//            }
//
//            PigHoldAction action = new PigHoldAction(this);
//            game.sendAction(action);
//            return;

            boolean roll = false;

            if(theGame.getCurrPlayerRunningScore() < 5){
                roll = true;
            } else {
                roll = false;
            }
Log.i("test", theGame.getCurrPlayerRunningScore()+"");
            if(roll){
                PigRollAction action = new PigRollAction(this);
                game.sendAction(action);
            } else {
                PigHoldAction action = new PigHoldAction(this);
                game.sendAction(action);
            }

        }
        else {
            return;
        }
    }//receiveInfo

}
