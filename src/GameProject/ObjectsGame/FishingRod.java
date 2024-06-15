package GameProject.objectsGame;

import javax.swing.*;
import java.awt.*;

public class FishingRod extends JPanel {
   // private int x = 300;
    //private int y = 130;
    private int lineLength = 80;
    private int rodX = 617;
    private int rodY = 80;
    private int hookDiameter = 12;
    private final int MAX_LINE_LENGTH = 660 ; // הגובה המקסימלי  החוט
    private final int MIN_LINE_LENGTH = 10;  // הגובה המינימלי החוט
    private Image hookPhoto;
    public FishingRod() {
   this.hookPhoto=new ImageIcon("src/GameProject/Images/HookPaint.png").getImage();

    }

    public void moveUp() {
        if (getHookY()<=MAX_LINE_LENGTH) {
            lineLength += 18;

        }


    }

    void moveDown() {
        if (lineLength-18>=MIN_LINE_LENGTH) {
            lineLength -= 18;

        }
    }

    public Rectangle getHookBounds() {
        return new Rectangle(getHookX(), getHookY(), hookDiameter, hookDiameter);
    }

    public Rectangle getFishingLineBounds() {
        return new Rectangle(getHookX() + 5, getHookY() - 650, 1, 650);
    }

    public int getHookY() {
        return rodY - 50 + lineLength - hookDiameter / 2;
    }

    public int getHookX() {
        return rodX - hookDiameter / 2;
    }

    public void paint(Graphics graphics) {
        graphics.drawImage(hookPhoto,rodX - 11 , rodY - 55 + lineLength - hookDiameter / 2, this);
        graphics.drawLine(rodX,rodY-50,rodX,rodY+lineLength-50);

        // graphics.drawLine(rodX, rodY - 50, rodX, rodY - 50 + lineLength);
       //  graphics.fillOval(rodX - hookDiameter / 2, rodY - 50 + lineLength - hookDiameter / 2, hookDiameter, hookDiameter);

        graphics.setColor(new Color(255, 255, 255, 0));//המלבן של החכה שקוף
        graphics.drawRect(getHookX() + 5, getHookY() - 650, 1, 650);


    }
}
