package edu.up.cs301.pig;

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

        int compId;
        if (this.name == this.allPlayerNames[0]) {
            compId = 0;
        }
        else {
            compId = 1;
        }
        if(theGame.getCurrID() == compId) {
            if (Math.random() < 0.5) {
                PigRollAction action = new PigRollAction(this);
                game.sendAction(action);
            }
            else {
                PigHoldAction action = new PigHoldAction(this);
                game.sendAction(action);
            }
        }
        else {
            return;
        }
    }//receiveInfo

}
