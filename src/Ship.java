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
    public void kill() {

    }

    @Override
    public void move() {
        if(getGame().isWPressed()){
            setDy(getDy() - .25);
        }
        if(getGame().isAPressed()){
            setDx(getDx()-.25);
        }
        if(getGame().isSPressed()){
            setDy(getDy()+.25);
        }
        if(getGame().isDPressed()){
            setDx(getDx()+.25);
        }

    }
}
