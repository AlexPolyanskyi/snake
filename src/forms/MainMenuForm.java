package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Алексей on 05.02.2015.
 */
public class MainMenuForm {
    public MainMenuForm(){
        JFrame window =null;
        window = createFrame(window);
        createMenu(window);
        window.setVisible(true);
    }

    private JFrame createFrame(JFrame window) {
        window = new JFrame("Main Menu");
        window.setSize(500,500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return window;
    }

    private void createMenu(final JFrame window) {
        JPanel menuPanel = new JPanel();
        window.getContentPane().add(BorderLayout.CENTER, menuPanel);
        menuPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JButton startButton = new JButton("Start game");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameForm();
                window.setVisible(false);
            }
        });
        menuPanel.add(startButton, c);
        JButton recordsButton = new JButton("Show record");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        recordsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        menuPanel.add(recordsButton, c);
    }
}
