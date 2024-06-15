package main;

import javax.swing.*;
import java.awt.*;
import static utilz.Constants.InstructionsConstants.*;

public class Instructions extends JPanel {
    private Image backgroundImage;
    private Image yellowFish;
    private Image bonusFish;
    private Image sharkImage;
    private Image pufferFishImage;
    private GameWindow window;

    public Instructions(GameWindow window) {
        this.window = window;
        this.backgroundImage = new ImageIcon("src/images/InstructionsBackground.jpg").getImage();
        this.setSize(WIDTH, HEIGHT);
        JLabel title = new JLabel("Welcome to Dangerous Fishing!");
        title.setSize(200, 200);
        title.setBounds(400, 10, 600, 200);
        Font fontTitle = new Font("Arial", Font.BOLD, 35);
        title.setFont(fontTitle);
        JTextArea instructions = new JTextArea(10, 20);
        instructions.setText("""
                in this game currently you can catch two type of fish  
                1.yellow fish -also called regular fish that worth 1 point every catch  
                2.gray fish - also called bonus fish that worth 3 points every catch! but It rarely spawns.
                But it's not that easy, the game also has Sharks and Puffer Fish that multiply faster as the score goes up 
                beyond the fact that you can't fish for a Shark, a shark can't touch the fishing line!
                for that the game starts with 3 lives, every time you touch a shark or puff fish one life goes down!
                Game operation:
                1. Use the arrow keys to move the hook up and down
                2. When a fish is caught on the rod, it must be brought up
                 to the tip of the rod and only then press the space bar
                As soon as you pressed the space key and the fish disappeared - a point was added to you."""
        );
        Font font = new Font("Arial", Font.BOLD, 18);
        instructions.setFont(font);
        instructions.setForeground(Color.WHITE);
        instructions.setBounds(165, 250, 985, 412);
        instructions.setBackground(new Color(50, 75, 150, 190));
        JButton backToMainMenu = new JButton();
        backToMainMenu.setText("Back to Main Menu");
        backToMainMenu.setFont(font);
        backToMainMenu.setForeground(Color.WHITE);
        backToMainMenu.setBounds(INSTRUCTIONS_WIDTH/(3+60), INSTRUCTIONS_HEIGHT/(3+80), 300, 100);
        backToMainMenu.setContentAreaFilled(false);
        backToMainMenu.addActionListener(e -> {
            window.showMainMenu();
        });
        this.add(backToMainMenu);

////////IMAGE FOR INSTRUCTIONS///////////

        JLabel sharkLabel = new JLabel("Shark");
        sharkLabel.setSize(SUB_TITLES_SIZE, SUB_TITLES_SIZE);
        sharkLabel.setBounds(800, IMAGE_LABEL_HEIGHT, SUB_TITLES_SIZE, SUB_TITLES_SIZE);
        this.add(sharkLabel);
        JLabel pufferFishLabel = new JLabel("Puffer Fish");
        pufferFishLabel.setSize(SUB_TITLES_SIZE, SUB_TITLES_SIZE);
        pufferFishLabel.setBounds(1015, IMAGE_LABEL_HEIGHT, SUB_TITLES_SIZE, SUB_TITLES_SIZE);
        this.add(pufferFishLabel);
        JLabel yellowFishLabel = new JLabel("Regular Fish");
        yellowFishLabel.setSize(SUB_TITLES_SIZE, SUB_TITLES_SIZE);
        yellowFishLabel.setBounds(230, IMAGE_LABEL_HEIGHT, SUB_TITLES_SIZE, SUB_TITLES_SIZE);
        this.add(yellowFishLabel);
        JLabel bonusFishLabel = new JLabel("Bonus Fish");
        bonusFishLabel.setSize(SUB_TITLES_SIZE, SUB_TITLES_SIZE);
        bonusFishLabel.setBounds(490, IMAGE_LABEL_HEIGHT, SUB_TITLES_SIZE, SUB_TITLES_SIZE);
        this.add(bonusFishLabel);
        this.yellowFish = new ImageIcon("src/images/Fish.png").getImage();
        this.bonusFish = new ImageIcon("src/images/bonusFish.png").getImage();
        this.sharkImage = new ImageIcon("src/images/Shark.png").getImage();
        this.pufferFishImage = new ImageIcon("src/images/PufferFish.png").getImage();

/////////////////////////////////////////

        this.add(instructions);
        this.add(title);
        this.setLayout(null);
        this.setVisible(true);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, INSTRUCTIONS_WIDTH, INSTRUCTIONS_HEIGHT, null);
        g.drawImage(yellowFish, FISH_X, FISH_Y + 30, FISH_WIDTH + 20, FISH_HEIGHT + 40, null);
        g.drawImage(bonusFish, (FISH_X * 2) + 50, FISH_Y + 60, FISH_WIDTH + 20, FISH_HEIGHT - 18 , null);
        g.drawImage(sharkImage, (FISH_X * 3)+ 100, FISH_Y + 45, FISH_WIDTH + 100, FISH_HEIGHT, null);
        g.drawImage(pufferFishImage, (FISH_X * 5), FISH_Y + 45, FISH_WIDTH - 4, FISH_HEIGHT, null);
    }

}
