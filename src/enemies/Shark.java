package enemies;
import javax.swing.*;
import java.awt.*;
import static utilz.Constants.FishConstants.*;
import static utilz.Constants.Images.SHARK_IMAGE;

public class Shark extends JPanel {
    private Image sharkImage;
    private Rectangle bodyLimit;
    private int x;
    private int y;

    public Shark(int x, int y) {
        this.bodyLimit = new Rectangle(x + 20, y + 20, WIDTH_DEFAULT, HEIGHT_DEFAULT);
        this.sharkImage = new ImageIcon(SHARK_IMAGE).getImage();
        this.setPreferredSize(new Dimension(sharkImage.getWidth(this), sharkImage.getHeight(this)));
        this.x = x;
        this.y = y;
    }

    public Rectangle getSharkBounds() {
        return new Rectangle(x + 20, y + 20, WIDTH_DEFAULT, HEIGHT_DEFAULT);
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

