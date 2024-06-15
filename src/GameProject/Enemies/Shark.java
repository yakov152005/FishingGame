package GameProject.enemies;

import javax.swing.*;
import java.awt.*;

public class Shark extends JPanel {
    private Image sharkImage;
    private Rectangle bodyLimit;
    private int x;
    private int y;

    public Shark(int x, int y) {
        this.bodyLimit = new Rectangle(x + 20, y + 20, 400, 100);
        this.sharkImage = new ImageIcon("src/GameProject/Images/Shark.png").getImage();
        this.setPreferredSize(new Dimension(sharkImage.getWidth(this), sharkImage.getHeight(this)));
        this.x = x;
        this.y = y;
    }

    public Rectangle getSharkBounds() {
        return new Rectangle(x + 20, y + 20, 400, 100);

    }

    public void moveRight() {
        this.x += 4;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.sharkImage, x, y, this);
        g.drawRect(x + 20, y + 20, bodyLimit.width, bodyLimit.height);
        g.setColor(new Color(255, 255, 255, 0));

    }
}

