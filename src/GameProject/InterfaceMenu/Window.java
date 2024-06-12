package GameProject.InterfaceMenu;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    //1920x1080
    public static final int WIDTH=1280;
    public static final int HEIGHT=720;
    private GamePanel gamePanel;
    private Instructions instructions;
   private MainMenu menu;

    public Window(){
       this.setTitle("Dangerous Fishing");
      //  this.gamePanel=gamePanel;

      this.setLayout(new BorderLayout());
      menu=new MainMenu(this);
      add(menu,BorderLayout.CENTER);
        this.setSize(WIDTH,HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void showGamePanel() {
        getContentPane().remove(menu);
        gamePanel = new GamePanel();
        add(gamePanel, BorderLayout.CENTER);
        gamePanel.requestFocusInWindow();
        revalidate();
        repaint();
    }
public void showInstructions(){
        getContentPane().remove(menu);
        instructions= new Instructions(this);
        add(instructions,BorderLayout.CENTER);
        revalidate();
        repaint();
}

public void showMainMenu(){
    getContentPane().remove(instructions);
    menu=new MainMenu(this);
    add(menu,BorderLayout.CENTER);
    revalidate();
    repaint();
}



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Window();

        });
    }
}



