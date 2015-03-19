package forms;

import gameUnit.SnakeUnit;
import managers.GameManager;
import managers.MoveManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Алексей on 05.02.2015.
 */
public class GameForm implements MoveManager.CallbackLose {
    private JFrame gameWindow = null;
    private JPanel gameMap = null;
    private Thread gameStart = null;
    private static JLabel pointLabel = null;
    GameForm(){
        createGameWindow();
        createControlPanel();
        gameMap = createGameMap();
        createStatePanel();
        gameWindow.setVisible(true);
    }

    private JPanel createGameMap() {
        JPanel gameMap = new JPanel();
        gameMap.setLayout(null);
        gameWindow.add(BorderLayout.CENTER, gameMap);
        SnakeUnit snake = new SnakeUnit(gameMap);
        return gameMap;
    }

    private void createStatePanel() {
        JPanel statePanel = new JPanel();
        statePanel.setBackground(Color.lightGray);
        statePanel.setLayout(new FlowLayout());
        gameWindow.add(BorderLayout.SOUTH, statePanel);
        JLabel timeLabel = new JLabel();
        timeLabel.setText("00:00");
        statePanel.add(timeLabel);
        pointLabel = new JLabel();
        statePanel.add(pointLabel);
        pointLabel.setText("Набранно очков: 0 ");
    }

    public static int setScore(int score) {
        pointLabel.setText("Набранно очков: "+ score);
        return score;
    }

    private void createControlPanel() {
        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(Color.lightGray);
        controlPanel.setLayout(new FlowLayout());
        gameWindow.add(BorderLayout.NORTH, controlPanel);
        final JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playButton.getText().equals("Play")) {
                    gameStart(playButton);
                }else{
                    gameStop(playButton);
                }
            }
        });
        controlPanel.add(playButton);
    }

    private void gameStop(JButton playButton) {
        playButton.setText("Play");
        GameManager.setPause();

    }

    private void gameStart(JButton playButton) {
        if(gameStart == null){
            gameStart = new Thread(new MoveManager(this, gameWindow, gameMap));
            GameManager.setDirection(GameManager.RIGHT);
            //StateGame.clearScore();
            gameStart.start();
        }else{
            GameManager.setPause();
        }
        playButton.setText("Pause");
        gameWindow.setFocusable(true);
        playButton.setFocusable(false);
    }

    private void createGameWindow() {
        gameWindow = new JFrame("SNAKE");
        gameWindow.setSize(506, 500);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                GameManager.setDirection(e.getKeyCode());
            }
        });
    }

    @Override
    public void gameOver() {
        System.out.println("loseloselose");
    }
}
