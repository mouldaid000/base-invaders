import java.awt.*;

/**
 * Created by mouldaid000 on 3/1/2017.
 */
public abstract class Entity{

    private Game game;
    private Color color;
    private int x, y,width, height, index;
    private double dx, dy, maxSpeed;
    public Entity(Color color, int x, int y, int width, int height, Game game, int index){

    }
    public boolean collides(Entity other){
        return getBounds().intersects(other.getBounds());
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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

    public void setY(double y) {
        this.y = (int)Math.round(y);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }
    public abstract void kill();
    public abstract void move();



}
