import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy extends Rectangle{

    public int spd = 2;
    public int curAnimation = 0;
    public int curFrames = 0, targetFrames = 15;
    public int right = 1, left = 0, up = 0, down = 0;
    public static List<Bullet> bullets = new ArrayList<>();
    public boolean shoot = false;
    public int dir = 1;

    public Enemy(int x, int y) {
        super(x, y, 32, 32);

    }

    public void followPlayer() {
        Player player = Game.player;
        if(x < player.x && World.isFree(x+spd, y)) {
            if(new Random().nextInt(100) < 50) {
                x+=spd;
            }
        }else if(x > player.x && World.isFree(x-spd, y)) {
            if(new Random().nextInt(100) < 50) {
                x -= spd;
            }
        }

        if(y < player.y && World.isFree(x, y+spd)) {
            if(new Random().nextInt(100) < 50) {
                y += spd;
            }
        } else if(y > player.y && World.isFree(x, y-spd)) {
            if(new Random().nextInt(100) < 50) {
                y -= spd;
            }
        }
    }

    public void tick() {
        boolean moved = true;

        followPlayer();

        if(right == 1 && World.isFree(x+spd, y)) {
            x++;
        }

        if(moved) {
            curFrames++;
            if(curFrames == targetFrames) {
                curFrames = 0;
                curAnimation++;
                if(curAnimation == SpriteSheet.player_front.length) {
                    curAnimation = 0;
                }
            }
        } else {
            curAnimation = 0;
        }

        if (shoot) {
            shoot = false;
            Bullet bullet = new Bullet(x, y, dir);
            bullets.add(bullet);
        }

        for(int i = 0; i < bullets.size(); i++) {
            bullets.get(i).tick();
        }
    }

    public void render(Graphics g) {
        g.drawImage(SpriteSheet.enemy_front[curAnimation], x, y, 32, 32, null);

        for(int i = 0; i < bullets.size(); i++) {
            bullets.get(i).render(g);
        }
    }
}
