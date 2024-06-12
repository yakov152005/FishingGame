package Trddd;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {

    public MainMenu(Try window) {
        JButton startButton = new JButton("Start");
        JButton optionsButton = new JButton("Options");
        JButton exitButton = new JButton("Exit");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.showGamePanel();
            }
        });

        add(startButton);
        add(optionsButton);
        add(exitButton);
    }
}