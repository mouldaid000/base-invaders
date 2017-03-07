import java.awt.*;

/**
 * Created by mouldaid000 on 3/1/2017.
 */
public class Ship extends Entity{
    boolean visible = true;

    public Ship(Color color, int x, int y, int width, int height, Game game, int index){
        super(color,x,y,width,height,game,index);
    }
    public void paint(Graphics g){
        if(visible){
            g.setColor(Color.red);
            g.fillOval(getX(),getY(), getWidth(), getHeight());
        }
    }

    @Override
    public void checkCollisions() {
        /*
        for(int i = 1; i < getGame().getNextChar(); i++){
            if(getGame().getHitbox(i).intersects(getBounds())){
                if(getGame().getEntity(i) instanceof Alien){
                    getGame().removeEntity(i);
                    Stats.health--;

                    if(Stats.getHealth() <= 0){
                        kill();
                    }
                }
            }
        }
        */
    }


    @Override
    public void kill() {

    }

    @Override
    public void move() {
        if(getGame().isWPressed()){
            setY(getY() - getDy());
        }
        if(getGame().isAPressed()){
            setX(getX() - getDx());
        }
        if(getGame().isSPressed()){
            setY(getY() + getDy());
        }
        if(getGame().isDPressed()){
            setX(getX() + getDx());
        }

    }
}
