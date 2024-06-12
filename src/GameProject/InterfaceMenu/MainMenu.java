package GameProject.InterfaceMenu;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    public static  final int BUTTON_CENTER=454;
    public static  final int BUTTON_HEIGHT=110;
    public static  final int BUTTON_WIDTH=410;
    private Image backgroundImage;
   private GamePanel gamePanel;
    private Window window;

    public MainMenu(Window window){
        this.window=window;
        this.backgroundImage=new ImageIcon("src/GameProject/Images/MainMenuBackground.jpg").getImage();
        this.setSize(WIDTH,HEIGHT);
        this.setLayout(null);
        this.setVisible(true);
        JButton start = new JButton("");
        start.setContentAreaFilled(false);
        start.addActionListener(e->  {
          window.showGamePanel();
        });

        JButton instructions = new JButton("");
        instructions.setContentAreaFilled(false);

        instructions.addActionListener(e ->{
            window.showInstructions();
        });
        JButton options = new JButton("");
        options.setContentAreaFilled(false);

        JButton exit = new JButton("");
        exit.addActionListener(e->  {
            System.exit(0);

        });

        exit.setContentAreaFilled(false);

        start.setBounds(BUTTON_CENTER, 187, BUTTON_WIDTH, BUTTON_HEIGHT);
        instructions.setBounds(BUTTON_CENTER, 312, BUTTON_WIDTH, BUTTON_HEIGHT);
        options.setBounds(BUTTON_CENTER, 435, BUTTON_WIDTH, BUTTON_HEIGHT);
        exit.setBounds(BUTTON_CENTER, 562, BUTTON_WIDTH, BUTTON_HEIGHT);
        this.add(start);
        this.add(instructions);
        this.add(options);
        this.add(exit);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, WIDTH, HEIGHT, null);
    }



}
