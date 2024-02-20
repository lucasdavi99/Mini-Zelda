import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {

    public static BufferedImage spriteSheet;
    public static BufferedImage[] player_front;
    public static BufferedImage[] enemy_front;
    public static BufferedImage tileWall;

    public SpriteSheet() {
        try {
            spriteSheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        player_front = new BufferedImage[2];
        enemy_front = new BufferedImage[2];

        player_front[0] = SpriteSheet.getSprite(0, 11, 16, 16);
        player_front[1] = SpriteSheet.getSprite(16, 11, 16, 16);

        enemy_front[0] = SpriteSheet.getSprite(153, 211, 16, 16);
        enemy_front[1] = SpriteSheet.getSprite(170, 211, 16, 16);

        tileWall = SpriteSheet.getSprite(280, 203, 16, 16);
    }

    public static BufferedImage getSprite(int x, int y, int width, int height) {
        return spriteSheet.getSubimage(x, y, width, height);
    }

    //122,210
}
