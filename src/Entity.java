import java.awt.*;

/**
 * Created by mouldaid000 on 3/1/2017.
 */
public abstract class Entity{

    public Game game;
    private Color color;
    private int width, height, x, dx = 4, dy = 4, index;
    public int y;
    public Entity(Color color, int x, int y, int width, int height, Game game, int index){
        this.game = game;
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.index = index;
    }
    public boolean collides(Entity other){
        return getBounds().intersects(other.getBounds());
    }

    public Game getGame() {
        return game;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public void setX(double x) {
        this.x = (int)Math.round(x);
    }

    public int getY() {
        return y;
    }

    public void setY(double y){this.y = Math.round(x);}

    public int getDy(){
        return dy;}

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy){
    this.dy = dy;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }

    public abstract void kill();

    public abstract void move();

    public abstract void paint(Graphics g);

    public abstract void checkCollisions();
    public int getIndex(){
            return index;
    }

    public void decrementIndex() {
        index--;
    }
}
