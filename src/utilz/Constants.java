package utilz;

import java.util.Random;

public class Constants {
    public static class MainMenuConstants{
        public static final int BACKGROUND_WIDTH = 1280;
        public static final int BACKGROUND_HEIGHT = 720;
        public static final int BUTTON_CENTER=454;
        public static final int BUTTON_HEIGHT=110;
        public static final int BUTTON_WIDTH=410;
    }
    public static class GameWindowConstants{
        public static final int GAME_WINDOW_WIDTH = 1280;
        public static final int GAME_WINDOW_HEIGHT = 720;
    }

    public static class InstructionsConstants{
        public static final int INSTRUCTIONS_WIDTH = 1280;
        public static final int INSTRUCTIONS_HEIGHT = 720;
        public static final int SUB_TITLES_SIZE = 100;
        public static final int IMAGE_LABEL_HEIGHT=180;
        public static final int FISH_X = 200;
        public static final int FISH_Y = 100;
        public static final int FISH_WIDTH = 100;
        public static final int FISH_HEIGHT = 80;
    }
    public static class LevelConstants{
        public static final int FISH_SPAWN_TIME = 7000;
        public static final int BONUS_FISH_SPAWN_TIME = 35000;
        public static final int SHARK_SPAWN_TIME = 25000;
        public static final int PUFFER_FISH_SPAWN_TIME = 10000;
        public static final int OCEAN_SHARK_START_HEIGHT = 233;
        public static final int OCEAN_FISHES_START_UPPER_LIMIT = 285;
        public static final int OCEAN_END_BOTTOM_LIMIT = 600;
        public static final int FISHES_WHO_START_FROM_RIGHT = 1200;
        public static final int FISHES_WHO_START_FROM_LEFT = -20;
        public static Random random = new Random();
        //Level One finals//
        public static final int START_NUM_OF_FISH = 35;
        public static final int START_NUM_OF_PUFFERS = 12;
        public static final int START_NUM_OF_SHARK = 8;
        public static final int START_NUM_OF_BONUS_FISH = 3;
    }
}
