package managers;

import forms.GameForm;
import gameUnit.PartSnakeUnit;
import gameUnit.SnakeUnit;

/**
 * Created by Алексей on 05.02.2015.
 */
public class GameManager {
    private static int direction = 39 ;
    public final static int RIGHT = 39;
    private static boolean respawn = false;
    private final static int START_SPEED = 203;
    private final static int MIN_SPEED = 50;
    private static boolean  pause = false;
    private static boolean gameOver = false;

    public static void refreshScore() {
        GameForm.setScore((SnakeUnit.getLengthSnake() - 3) * 100);
    }

    public static void setGameOver(){
        gameOver = true;
    }

    public static boolean isGameOver() {
        return gameOver;
    }

    public static boolean isPause(){
        return pause;
    }

    public static void setPause(){
        if(pause){
            pause = false;
        }else{
            pause = true;
        }
    }

    public static PartSnakeUnit getNewPart() {
        return newPart;
    }

    public static void setNewPart(PartSnakeUnit newPart) {
        GameManager.newPart = newPart;
    }

    private static PartSnakeUnit newPart = null;

    public static int getxCordNewPart() {
        return newPart.getX();
    }

    public static int getyCordNewPart() {
        return newPart.getY();
    }

    public static void setDirection(int direction) {
        GameManager.direction = direction;
    }

    public static int getDirection() {
        return direction;
    }

    public static boolean isRespawn(){
        return respawn;
    }

    public static void setRespawn(boolean r) {
        respawn = r;
    }

    public static int getSpeed(){
        int speed = START_SPEED - SnakeUnit.getLengthSnake() * 2;
        return MIN_SPEED <= speed ? speed : MIN_SPEED;
    }
}
