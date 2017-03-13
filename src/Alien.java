import java.awt.*;

/**
 * Created by mouldaid000 on 3/1/2017.
 */
public class Alien extends Entity {

    public Alien(Color color, int x, int y, int width, int height, Game game, int index) {

        super(color, x, y, width, height, game, index);

    }

    public void paint(Graphics g) {

        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void checkCollisions() {
        if (getX() + getWidth() > getGame().getWidth() || getX() < 0) {
            setDx(getDx() * -1);
            setY(25);
        }

    }

    @Override
    public void kill() {
        Stats.addScore();
        for (int i = 1; i < getGame().getNextChar(); i++) {
            if (getGame().getBullet(i).getBounds().intersects(getBounds())) {
                if(getGame().getEntity(i) instanceof Bullet) {
                    getGame().getEntity(i).kill();
                }
            }
        }
    }

        @Override
        public void move () {
            setX(getX() + getDx());

        }
}
