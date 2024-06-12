package Trddd;

import javax.swing.*;
import java.awt.*;

public class Try extends JFrame {

    private MainMenu mainMenu;
    private GamePanel gamePanel;

    public Try() {
        setTitle("Game Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        mainMenu = new MainMenu(this);
        add(mainMenu, BorderLayout.CENTER);

        setVisible(true);
    }

    public void showGamePanel() {
        getContentPane().remove(mainMenu);
        gamePanel = new GamePanel();
        add(gamePanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Try();
        });
    }
}