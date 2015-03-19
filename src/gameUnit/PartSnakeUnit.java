package gameUnit;

import managers.GameManager;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Алексей on 05.02.2015.
 */
public class PartSnakeUnit extends JPanel {
    private Color color = Color.black;
    private final int width = 10, height = 10;
    private int xCord = 0, yCord = 0;
    public PartSnakeUnit(int xCord, int yCord){
        this.xCord = xCord;
        this.yCord = yCord;
        setBackground(color);
        setSize(width, height);
        setLocation(xCord, yCord);
    }
    public PartSnakeUnit(){
        boolean isMatches = true;
        do {
            xCord = ((int) (Math.random()*470)/10*10);
            yCord = ((int) (Math.random()*370)/10*10);
            for (PartSnakeUnit partSnakeUnit : SnakeUnit.getSnake()){
                if ( ( xCord != partSnakeUnit.getX() ) || ( yCord != partSnakeUnit.getY()) ) {
                    isMatches = false;
                } else {
                    break;
                }
            }
        }
        while(isMatches);
        GameManager.setRespawn(true);
        setLocation(xCord, yCord);
        setSize(width, height);
        setBackground(Color.red);
    };

}
