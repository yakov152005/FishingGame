package GameProject.fishes;

import javax.swing.*;
import java.awt.*;

public class Fish extends JPanel {
    private int x;
    private int y;
    private Image fishImage;
    private Rectangle headBox;
    private boolean isCaught = false;
    public final int FISH_BOX_SIZE = 25;


    public Fish(int x, int y) {
        this.fishImage = new ImageIcon("src/GameProject/Images/fish.png").getImage();
        this.x = x;
        this.y = y;
        //   this.setPreferredSize(new Dimension(fishImage.getWidth(this), fishImage.getHeight(this)));
        this.headBox = new Rectangle(this.x, this.y, FISH_BOX_SIZE, FISH_BOX_SIZE);
    }

    public void setFishImage() {
        this.fishImage = new ImageIcon("src/GameProject/Images/FishCatch.png").getImage();
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public Rectangle getBoxBounds() {
        return new Rectangle(x + 110, y + 70, FISH_BOX_SIZE, FISH_BOX_SIZE);
    }


    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isCaught() {
        return isCaught;
    }

    public boolean setCaught(boolean isCaught) {
        return this.isCaught = isCaught;
    }

    public void moveRight() {

        this.x += 5;
    }

    public void moveLeft() {
        this.x--;
    }

    public void moveUp() {
        this.y--;
    }

    public void moveDown() {
        this.y++;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fishImage, x, y, null);
        g.drawRect(x + 115, y + 70, headBox.width, headBox.height);
        g.setColor(new Color(255, 255, 255, 0));


    }


}
