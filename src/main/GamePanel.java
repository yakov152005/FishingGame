package main;

import enemies.PufferFish;
import enemies.Shark;
import fishes.BonusFish;
import fishes.Fish;
import level.Levels;
import objectsGame.FishingRod;
import objectsGame.KeyboardListener;


import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class GamePanel extends JPanel {
    private Image backgroundImage;
    private FishingRod rod;
    private Fish fish;
    private Shark shark;
    private ArrayList<Shark> sharks;
    private ArrayList<Shark> toRemoveSharks;
    private ArrayList<Fish> fishes;
    private ArrayList<Fish> flippedFishes;
    private PufferFish pufferFish;
    private ArrayList<PufferFish> pufferFishes;
    private ArrayList<PufferFish> toRemovePufferFish;
    private ArrayList<BonusFish> bonusFish;
    private BonusFish bonus;
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    private JLabel scoreLabel;
    private JLabel leftHeart;
    private JLabel middleHeart;
    private JLabel rightHeart;
    private int score;
    private int currentLevel = 1;
    private int lives = 3;
    private boolean getInBag = false; //
    private Levels levels;
    private int gameOver = 0;


    public GamePanel() {
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.backgroundImage = new ImageIcon("src/images/Background.png").getImage();
        this.setSize(WIDTH, HEIGHT);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLayout(null);
        scoreLabel();
        life();
        this.rod = new FishingRod();
        this.add(this.rod);
        this.Music("src/images/Aquarium.wav");
        this.fish = new Fish(0, 0);
        this.bonusFish = new ArrayList<>();
        this.shark = new Shark(0, 0);
        this.sharks = new ArrayList<>();
        this.toRemoveSharks = new ArrayList<>();
        this.pufferFish = new PufferFish(0, 0);
        this.pufferFishes = new ArrayList<>();
        this.toRemovePufferFish = new ArrayList<>();
        this.fishes = new ArrayList<>();
        this.flippedFishes = new ArrayList<>();
        this.bonus = new BonusFish(0, 0);
        this.levels = new Levels(fishes, bonusFish, sharks, pufferFishes);
        levels.levelHardness(1, 1);
        this.addKeyListener(new KeyboardListener(this, this.rod, this.fish, this.fishes, this.bonusFish, this.bonus));
        this.setFocusable(true);
        this.mainGameLoop();
        this.setVisible(true);
    }

    public void Music(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mainGameLoop() {
        gameOver = 0;
        new Thread(() -> {
            while (lives > gameOver) {
                for (Fish currentFish : fishes) {
                    currentFish.moveRight();

                    if (checkCollision(currentFish, rod) && !this.getInBag) {
                        currentFish.setCaught(true);
                    }

                    if (currentFish.isCaught() && !this.getInBag) {
                        currentFish.setPosition(rod.getHookX() - currentFish.getX() / 7, rod.getHookY() - currentFish.getY() / 7); // כיוון תמונה שהדג בחכה
                    }

                }

                for (BonusFish currentBonusFish : this.bonusFish) {
                    if (!currentBonusFish.isCaught())
                        currentBonusFish.moveLeft();

                    if (checkCollisionWithBonus(currentBonusFish, rod) && !this.getInBag) {
                        currentBonusFish.setCaught(true);

                    }
                    if (currentBonusFish.isCaught() && !this.getInBag) {
                        currentBonusFish.setPosition(rod.getHookX() - currentBonusFish.getX() / 20, rod.getHookY() - currentBonusFish.getY() / 25); // הזז את מיקום הדג לקרוב לחכה
                    }


                }


                for (PufferFish currentPuffFish : pufferFishes) {
                    currentPuffFish.moveLeft();
                    if (collisionWithPufferFish(currentPuffFish, rod)) {

                        checkLives(lives);
                        toRemovePufferFish.add(currentPuffFish);

                    }
                }
                removePufferFish();

                for (Shark currentShark : sharks) {
                    currentShark.moveRight();
                    if (collisionWithShark(currentShark, rod)) {
                        checkLives(lives);
                        toRemoveSharks.add(currentShark);
                    }
                }
                removeSharksFromList();
                if (this.lives == 0) {
                    showGameOver();

                }

                sleep(50);

                repaint();
            }
        }).start();
    }

    public boolean checkCollision(Fish fish, FishingRod rod) {
        if (rod.getHookBounds().intersects(fish.getBoxBounds())) {
            fish.setFishImage();
            fish.setCaught(true);
            return true;
        } else {
            return false;
        }
    }

    public boolean collisionWithShark(Shark shark, FishingRod rod) {
        if (rod.getHookBounds().intersects(shark.getSharkBounds()) || rod.getFishingLineBounds().intersects(shark.getSharkBounds())) {
            lives--;
            return true;
        }
        return false;
    }

    public boolean collisionWithPufferFish(PufferFish pufferFish, FishingRod rod) {
        if (rod.getHookBounds().intersects(pufferFish.getPufferFishBounds()) || rod.getFishingLineBounds().intersects(pufferFish.getPufferFishBounds())) {
            lives--;
            return true;
        }
        return false;
    }

    public boolean checkCollisionWithBonus(BonusFish bonus, FishingRod rod) {
        if (rod.getHookBounds().intersects(bonus.getBonusBounds())) {
            bonus.setFishImage();
            bonus.setCaught(true);
            return true;
        } else {
            return false;
        }
    }

    public void removeSharksFromList() {
        for (Shark toRemove : toRemoveSharks) {
            this.sharks.remove(toRemove);
        }
        toRemoveSharks.clear();
    }

    public void removePufferFish() {
        for (PufferFish toRemove : toRemovePufferFish) {
            this.pufferFishes.remove(toRemove);
        }
        toRemovePufferFish.clear();
    }


    public void checkLives(int lives) {
        switch (lives) {
            case 1:
                middleHeart.setVisible(false);
                break;
            case 2:
                rightHeart.setVisible(false);
                break;
            case 3:
                leftHeart.setVisible(false);
                break;

        }

    }

    public void life() {
        leftHeart = new JLabel();
        leftHeart.setIcon(new ImageIcon("src/images/heart.png"));
        leftHeart.setBounds(50, 20, 50, 50);
        this.add(leftHeart);
        middleHeart = new JLabel();
        middleHeart.setIcon(new ImageIcon("src/images/heart.png"));
        middleHeart.setBounds(105, 20, 50, 50);
        this.add(middleHeart);
        rightHeart = new JLabel();
        rightHeart.setIcon(new ImageIcon("src/images/heart.png"));
        rightHeart.setBounds(160, 20, 50, 50);
        this.add(rightHeart);
        new JLabel();
    }


    public void checkDifficult(int score) {
        int newLevel = currentLevel;
        int toDived = 1;
        if (score <= 5) {
            newLevel = 1;
        } else if (score >= 10 && score < 25) {
            newLevel = 2;
        } else if (score >= 25) {
            newLevel = 3;
            toDived = 2;
        }

        if (newLevel != currentLevel) {
            currentLevel = newLevel;
            levels.levelHardness(newLevel, toDived);
            System.out.println("Level " + newLevel + " Begins!");
        }
    }


    public void scoreLabel() {
        this.scoreLabel = new JLabel("" + this.score);
        this.scoreLabel.setSize(400, 400);
        this.scoreLabel.setBounds(245, -30, 400, 400);
        Font labelFont = new Font("Arial", Font.BOLD, 42);
        this.scoreLabel.setFont(labelFont);
        this.add(scoreLabel);
    }

    public void addScore(int num) {
        score += num;
        this.scoreLabel.setText("" + this.score);
        System.out.println(score);
        checkDifficult(score);

    }


    public void removeFish(Fish fish) {
        this.fishes.remove(fish);
        this.getInBag = false;

    }

    public void removeBonusFish(BonusFish fish) {
        this.bonusFish.remove(fish);
        this.getInBag = false;

    }

    public void paintComponent(Graphics graphics) throws ConcurrentModificationException {
        graphics.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        super.paintComponent(graphics);
        this.rod.paint(graphics);
        try {
            for (Shark sharks : this.sharks) {
                sharks.paintComponent(graphics);
            }
            for (PufferFish currentPufferFish : this.pufferFishes) {
                currentPufferFish.paintComponent(graphics);
            }
            for (Fish fishes : this.fishes) {
                fishes.paintComponent(graphics);
            }
            for (BonusFish currentBonus : this.bonusFish) {
                currentBonus.paintComponent(graphics);
            }
            for (Fish fishes : this.flippedFishes) {
                fishes.paintComponent(graphics);
            }
        } catch (Exception e) {}
        repaint();
    }

    private void showGameOver() {
        JLabel gameOverLabel = new JLabel("GAME OVER");
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 72));
        gameOverLabel.setForeground(Color.RED);
        gameOverLabel.setBounds(WIDTH / 3 - 30, HEIGHT / 2, 900, 100);
        JButton exitButton = new JButton();
        exitButton.setText("Exit");
        exitButton.setBounds(500, 200, 200, 100);
        exitButton.setBackground(Color.cyan);
        exitButton.addActionListener(e -> {
            System.exit(0);
        });
        this.add(exitButton);
        this.add(gameOverLabel);
        // this.repaint();
    }


    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}





