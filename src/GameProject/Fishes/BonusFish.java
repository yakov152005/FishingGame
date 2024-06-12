package GameProject.Fishes;

import javax.swing.*;
import java.awt.*;
import java.security.PublicKey;

public class BonusFish extends Fish {
    private int x;
    private int y;
    private Image bonusImage;

    public BonusFish(int x, int y) {
        super(x, y);
        this.x = x;
        this.y = y;
        this.bonusImage = new ImageIcon("src/GameProject/Images/bonusfliped.png").getImage();


    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    public void setFishImage() {
        this.bonusImage = new ImageIcon("src/GameProject/Images/bonusFishCatch.png").getImage();


    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;


    }

    @Override
    public boolean setCaught(boolean isCaught) {
        return super.setCaught(isCaught);
    }

    public Rectangle getBonusBounds() {
        return new Rectangle(x, y + 35, 25, 30);

    }

    public void moveRight() {

        this.x += 5;
    }

    public void moveLeft() {
        this.x -= 10;

    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(this.bonusImage, x, y, this);
        g.drawRect(x, y + 35, 25, 30);
        //  g.setColor(Color.red);
    }
}
