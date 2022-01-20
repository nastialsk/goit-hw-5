class Level {
    private static int width;
    private static int height;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
}
class LevelTooBigException extends Exception {
    LevelTooBigException() {
        super("Level too big");
    }
}

class LevelLoader {
    public void load(Level level) throws LevelTooBigException {
        if (Level.getWidth()*Level.getHeight()>100000) {
            throw new
                    LevelTooBigException();}
        System.out.println("Level loaded");
        
    }
}

class LevelLoaderTest {
    public static void main(String[] args) {
        //Level loaded
        try {
            new LevelLoader().load(new Level(10, 20));
        } catch (LevelTooBigException ex) {
            System.out.println("Level too big");
        }

        //Level too big
        try {
            new LevelLoader().load(new Level(10000, 2000));
        } catch (LevelTooBigException ex) {
            System.out.println("Level too big");
        }
    }
}
