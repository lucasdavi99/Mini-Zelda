import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class World {

    public static List<Blocks> blocks = new ArrayList<Blocks>();

    public World() {
        for(int xx = 0; xx < Game.WIDTH*2; xx+=32) {
            blocks.add(new Blocks(xx, 0));
        }
        for(int xx = 0; xx < Game.WIDTH*2; xx+=32) {
            blocks.add(new Blocks(xx, Game.HEIGHT-32));
        }
        for(int yy = 0; yy < Game.HEIGHT*2; yy+=32) {
            blocks.add(new Blocks(0, yy));
        }
        for(int yy = 0; yy < Game.HEIGHT*2; yy+=32) {
            blocks.add(new Blocks(Game.WIDTH-32, yy));
        }
    }

    public static boolean isFree(int x, int y) {
        for(int i = 0; i < blocks.size(); i++) {
            Blocks bloco = blocks.get(i);
            if(bloco.intersects(new Rectangle(x, y, 32, 32))) {
                return false;
            }
        }
        return true;
    }

    public void render(Graphics g) {
        for(int i = 0; i < blocks.size(); i++) {
            blocks.get(i).render(g);
        }
    }
}