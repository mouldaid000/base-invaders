import java.awt.*;

/**
 * Created by mouldaid000 on 3/1/2017.
 */
public class Bullet extends Entity{
    private int bulletTimer;
    public Bullet(Color color, int x, int y, int width, int height, int dy, Game game, int index){
        super(color, x, y, width, height, game, index);
        setDy(getDy());
        bulletTimer = 180;

    }

    @Override
    public void kill() {
        getGame().removeEntity(getIndex());
    }

    @Override
    public void move() {

        this.y -=  this.getDy();
        bulletTimer--;
        if(bulletTimer <= 0){
            getGame().removeEntity(getIndex());
        }
    }

    @Override
    public void paint(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillOval(getX(), getY(), getWidth(), getHeight());

    }

    @Override
    public void checkCollisions() {
        for(int i = 1; i < getGame().getNextEntity(); i++){
            if(getGame().getHitbox(i).intersects(getBounds())){
                if(getGame().getEntity(i) instanceof Alien){
                    getGame().getEntity(i).kill();
                }
            }
        }
    }


}
