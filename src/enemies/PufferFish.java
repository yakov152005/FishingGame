package enemies;
import javax.swing.*;
import java.awt.*;

public class PufferFish extends JPanel {
    private int x;
    private int y;
    private Image pufferFishImage;

    public PufferFish(int x, int y) {
        this.x = x;
        this.y = y;
        this.pufferFishImage = new ImageIcon("src/images/PufferFish.png").getImage();
    }

    public void moveLeft() {
        this.x -= 5;
    }

    public Rectangle getPufferFishBounds() {
        return new Rectangle(this.x + 10, this.y + 17, 95, 90);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(pufferFishImage, x, y, this);
        graphics.drawRect(this.x + 10, this.y + 17, 95, 90);
    }
}
