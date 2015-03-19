package managers;

import forms.GameForm;
import gameUnit.PartSnakeUnit;
import gameUnit.SnakeUnit;

import javax.swing.*;

/**
 * Created by Алексей on 05.02.2015.
 */
public class MoveManager implements Runnable {
    private JFrame gameWindow;
    private JPanel gameMap;
    private CallbackLose callback;
    public MoveManager(CallbackLose c, JFrame gameWindow, JPanel gameMap){
        callback = c;
        this.gameWindow = gameWindow;
        this.gameMap = gameMap;
    }
    public static interface CallbackLose {
        void gameOver();
    }
    @Override
    public void run() {
        for (int i = 0; !GameManager.isGameOver(); i++) {
            try {
                Thread.sleep(GameManager.getSpeed());
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            if (!GameManager.isRespawn() && !GameManager.isPause()) {
                GameManager.setNewPart(new PartSnakeUnit());
                gameMap.add(GameManager.getNewPart());
            } else if (SnakeUnit.isAddNewPart(GameManager.getDirection()) && !GameManager.isPause()) {
                SnakeUnit.newPart();
                GameManager.refreshScore();
            }
            if(SnakeUnit.isCrash()){
                GameManager.setGameOver();
                callback.gameOver();
            } else if (!GameManager.isPause()) {
                SnakeUnit.move(GameManager.getDirection());
                gameWindow.repaint();
            }
        }
    }
}