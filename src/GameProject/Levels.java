package GameProject;

import GameProject.Enemies.PufferFish;
import GameProject.Enemies.Shark;
import GameProject.Fishes.BonusFish;
import GameProject.Fishes.Fish;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Levels {
    private ArrayList<Fish> fishes;
    private ArrayList<PufferFish> pufferFishes;
    private ArrayList<Shark> sharks;
    private ArrayList<BonusFish> bonusFish;
    public static final int FISH_SPAWN_TIME = 7000;
    public static final int BONUS_FISH_SPAWN_TIME = 35000;
    public static final int SHARK_SPAWN_TIME = 25000;
    public static final int PUFFER_FISH_SPAWN_TIME = 10000;
    public static final int OCEAN_SHARK_START_HEIGHT = 233;
    public static final int OCEAN_FISHES_START_UPPER_LIMIT = 285;
    public static final int OCEAN_END_BOTTOM_LIMIT = 600;
    public static final int FISHES_WHO_START_FROM_RIGHT = 1200;
    public static final int FISHES_WHO_START_FROM_LEFT = -20;
    //Level One finals//
    public static int startNumOfFish = 35;
    public static int startNumOfPuffers = 12;
    public static int startNumOfShark = 8;
    public static int startNumOfBonusFish = 3;
    private Random random;

    public Levels(ArrayList<Fish> fishes, ArrayList<BonusFish> bonusFish, ArrayList<Shark> sharks, ArrayList<PufferFish> pufferFishes) {
        this.fishes = fishes;
        this.bonusFish = bonusFish;
        this.sharks = sharks;
        this.pufferFishes = pufferFishes;
        this.random = new Random();
    }


    public void levelHardness(int multiply, int divide) {
        spawnFishLevel(FISH_SPAWN_TIME / divide, startNumOfFish * multiply);
        spawnPufferFish(PUFFER_FISH_SPAWN_TIME / divide, startNumOfPuffers * multiply);
        spawnBonusFish(BONUS_FISH_SPAWN_TIME / divide, startNumOfBonusFish * multiply);
        spawnSharksLevel(SHARK_SPAWN_TIME / divide, startNumOfShark * multiply);
    }

    public void spawnSharksLevel(long time, int numberToSpawn) {
        new Thread(() -> {
            int min = 0;
            while (min < numberToSpawn) {
                this.sharks.add(new Shark(random.nextInt(FISHES_WHO_START_FROM_LEFT, 0), random.nextInt(OCEAN_SHARK_START_HEIGHT, OCEAN_END_BOTTOM_LIMIT)));
                min++;
                sleep(time);
            }
        }).start();

    }

    public void spawnFishLevel(long time, int numberToSpawn) {
        new Thread(() -> {
            int min = 0;
            while (min < numberToSpawn) {
                this.fishes.add(new Fish(random.nextInt(FISHES_WHO_START_FROM_LEFT, 0), random.nextInt(OCEAN_FISHES_START_UPPER_LIMIT, OCEAN_END_BOTTOM_LIMIT)));
                min++;
                sleep(time);
            }
        }).start();
    }

    public void spawnBonusFish(long time, int numberToSpawn) {
        new Thread(() -> {
            int min = 0;
            while (min < numberToSpawn) {
                this.pufferFishes.add(new PufferFish(random.nextInt(FISHES_WHO_START_FROM_RIGHT, FISHES_WHO_START_FROM_RIGHT + 50), random.nextInt(OCEAN_FISHES_START_UPPER_LIMIT, OCEAN_END_BOTTOM_LIMIT)));
                min++;
                sleep(time);
            }
        }).start();
    }

    public void spawnPufferFish(long time, int numberToSpawn) {
        new Thread(() -> {
            int min = 0;
            while (min < numberToSpawn) {
                this.bonusFish.add(new BonusFish(random.nextInt(FISHES_WHO_START_FROM_RIGHT, FISHES_WHO_START_FROM_RIGHT + 50), random.nextInt(OCEAN_FISHES_START_UPPER_LIMIT, OCEAN_END_BOTTOM_LIMIT)));
                min++;
                sleep(time);


            }
        }).start();
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
