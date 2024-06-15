package main;
import audio.Audio;
import gamestates.Instructions;
import gamestates.Option;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import static utilz.Constants.GameWindowConstants.*;
import static utilz.Constants.Text.*;

public class GameWindow extends JFrame {
    private GamePanel gamePanel;
    private Instructions instructions;
    private MainMenu menu;
    private Option option;
    private static Audio audioPlayer;
    private static boolean isSoundOn = true;


    public GameWindow(){
       this.setTitle(FOR_INSTRUCTION_WINDOW);
       this.setLayout(new BorderLayout());

       menu = new MainMenu(this);
       add(menu,BorderLayout.CENTER);

       this.setSize(GAME_WINDOW_WIDTH,GAME_WINDOW_HEIGHT);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);

       playAudio();

       this.setLocationRelativeTo(null);
       this.setVisible(true);
    }

    public void showGamePanel() {
        getContentPane().remove(menu);
        gamePanel = new GamePanel();
        add(gamePanel, BorderLayout.CENTER);
        gamePanel.requestFocusInWindow();
        update();
    }

    public void showInstructions(){
        getContentPane().remove(menu);
        instructions = new Instructions(this);
        add(instructions,BorderLayout.CENTER);
        update();
    }

    public void showMainMenu(){
        getContentPane().removeAll();
        menu = new MainMenu(this);
        add(menu,BorderLayout.CENTER);
        update();
    }
    public void showOption(){
        getContentPane().removeAll();
        option = new Option(this);
        add(option,BorderLayout.CENTER);
        update();
    }

    public void playAudio(){
        try {
            audioPlayer = new Audio();
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {}
    }

    public static void toggleSound() {
        if (audioPlayer != null) {
            if (isSoundOn) {
                audioPlayer.stopAudio();
                isSoundOn = false;
            } else {
                audioPlayer.startAudio();
                isSoundOn = true;
            }
        }
    }
    public boolean isIsSoundOn(){
        return isSoundOn;
    }

    public void update(){
        revalidate();
        repaint();
    }
}



