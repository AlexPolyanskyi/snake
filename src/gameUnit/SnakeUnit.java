package gameUnit;

import managers.GameManager;

import javax.swing.*;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Алексей on 05.02.2015.
 */
public class SnakeUnit {
    private static JPanel gameMap;
    private static List<PartSnakeUnit> snake;
    public SnakeUnit(JPanel gameMap){
        this.gameMap = gameMap;
        snake = new LinkedList();
        initSnake();
    }

    public static int getLengthSnake() {
        return snake.size();
    }

    public static List<PartSnakeUnit> getSnake() {
        return snake;
    }

    public static boolean isAddNewPart(int direction){
        int partX = snake.get(getLengthSnake()-1).getX();
        int partY = snake.get(getLengthSnake()-1).getY();
        switch (direction){
            case 39: partX += 10; break;
            case 37: partX -= 10; break;
            case 40: partY += 10; break;
            case 38: partY -= 10; break;
        }
        if (partX == GameManager.getxCordNewPart() && partY == GameManager.getyCordNewPart()){
            return true;
        }else {
            return false;
        }
    }

    private void initSnake() {
        addPart(new PartSnakeUnit(50, 50));
        addPart(new PartSnakeUnit(60, 50));
        addPart(new PartSnakeUnit(70, 50));
    }

    private static void addPart(PartSnakeUnit part) {
        snake.add(part);
        gameMap.add(part);
    }

    public static void move(int direction) {
        PartSnakeUnit part = snake.get(0);
        int partX = snake.get(getLengthSnake() - 1).getX();
        int partY = snake.get(getLengthSnake() - 1).getY();
        switch (direction){
            case 39: part.setLocation(partX + 10, partY); break;
            case 37: part.setLocation(partX - 10, partY); break;
            case 40: part.setLocation(partX, partY + 10); break;
            case 38: part.setLocation(partX, partY - 10); break;
        }
        snake.add(part);
        snake.remove(0);
    }

    public static void newPart() {
        PartSnakeUnit partSnakeUnit = GameManager.getNewPart();
        partSnakeUnit.setBackground(Color.black);
        snake.add(0, partSnakeUnit);
        GameManager.setRespawn(false);
    }

    public static boolean isCrash(){
        if( crashFromYourself() || crashFromBorder()){
            return true;
        } else {
            return false;
        }
    }

    private static boolean crashFromBorder() {
        int partX = snake.get(getLengthSnake() - 1).getX();
        int partY = snake.get(getLengthSnake() - 1).getY();
        if ((partX >= gameMap.getWidth() || partX < 0) || (partY >= gameMap.getHeight() || partY < 0)){
            return true;
        } else {
            return false;
        }
    }

    private static boolean crashFromYourself() {
        return false;
    }
}
