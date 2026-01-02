package Utilz;

public class Variables {
    
    // Tile size variables

    public static final int RETRO_TILE_SIZE = 32;
    public static final int SCALE = 2;
    public static final int TILE_SIZE = RETRO_TILE_SIZE * SCALE;

    // Window size variables
    
    public static final int WINDOW_TILES_WIDTH = 24;
    public static final int WINDOW_TILES_HEIGHT = 14;

    public static final int WINDOW_WIDTH = WINDOW_TILES_WIDTH * TILE_SIZE;
    public static final int WINDOW_HEIGHT = WINDOW_TILES_HEIGHT * TILE_SIZE;

    // Running systems

    public static final int FPS = 60;

    // Entity settings

        // Anim Cycle

    public static final int IDLE = 0;
    public static final int RUN = 1;
    public static final int JUMP = 2;
    public static final int FALL = 3;
    public static final int ATTACKED = 4;
    public static final int DIE = 5;    

        // Entity Image
    
    public static final int EntityWidth = 64 * SCALE;
    public static final int EntityHeight = 40 * SCALE;
    public static final int EntityOffset = 32;

}
