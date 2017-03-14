import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by mouldaid000 on 3/1/2017.
 */
public class Game extends JPanel implements ActionListener{

    ArrayList<Entity> entities;
    ArrayList<Entity> ship;

    static Timer timer;

    public boolean wPressed, aPressed, sPressed, dPressed, spacePressed, lClick;

    public Game() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Base Invaders");
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.DARK_GRAY);
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    wPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    aPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    sPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    dPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_P) {
                    Stats.togglePause();
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    spacePressed = true;
                    Stats.startPlay();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    wPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    aPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    sPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    dPressed = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    spacePressed = false;
                }
            }
        });
        addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getButton() == MouseEvent.BUTTON1){
                    lClick = true;
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(e.getButton() == MouseEvent.BUTTON1){
                    lClick = false;
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
            }
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }
            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });

    }
    public static void main(String[] args){
        Game game = new Game();
        game.init();
        game.run();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(Stats.isPlay()){
            collisions();
            entities.get(0).move();
            if(entities.size() >= 1){
                for(int i = 0; i < entities.size(); i++){
                    entities.get(i).move();
                }
            }

            for(int i = 1; i < entities.size(); i++){
                entities.get(i).move();
            }
        }

        if(Stats.isEnd()){
            if(isSpacePressed()){
                resetGame();
            }
        }
        repaint();
    }

    public void resetGame() {
        for(int i = 1; i < getNextEntity(); i++){
            removeEntity(i);
        }
        for(int i = 1; i < 6; i++){
            entities.add(new Alien(Color.GREEN, (i*(150/3))+15,(i*(150/3))+15,12,12, this, entities.size()));
        }
        Stats.startPlay();
    }

    public void init() {
        entities = new ArrayList<Entity>();

        entities.add(new Ship(Color.RED, getWidth() / 2, getHeight() - 75, 30, 30, this, 0));
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 10; j++){
                entities.add(new Alien(Color.GREEN, (j*(150/3))+15, (i*(150/3))+15, 20, 20, this, entities.size()));
            }
        }
    }

    public void run(){
        timer = new Timer(1000/60, this);
        timer.start();
    }

    public void collisions() {

        for (int i = 0; i < entities.size(); i++){
            entities.get(i).checkCollisions();
        }

    }
    public void paint(Graphics g){
        super.paint(g);
        if(Stats.isMenu()){
            g.setFont(new Font("comic sans ms", Font.BOLD, 72));
            g.setColor(Color.BLACK);
            printSimpleString("Base Invaders",getWidth(),-5,(getHeight()/2)-5,g);
            g.setColor(Color.RED);
            printSimpleString("Base Invaders", getWidth(), 0, (getHeight()/2),g);
            g.setColor(Color.BLACK);
            g.setFont(new Font("comic sans ms", Font.BOLD, 32));
            printSimpleString("Press [SPACE] to Begin", getWidth(), -3, (getHeight()/2)+73,g);
            g.setColor(Color.RED);
            printSimpleString("Press [SPACE] to Begin", getWidth(), 0, (getHeight()/2)+75,g);
        }
        if(Stats.isPlay()){
            for(Entity e : entities){
                e.paint(g);
            }

            g.setFont(new Font("comic sans ms", Font.PLAIN, 24));
            g.setColor(Color.CYAN);
            printSimpleString("Score: " +Stats.getScore(), getWidth(), -330, getHeight() - 5, g);
        }
        if(Stats.isPause()){
            g.setFont(new Font("comic sans ms", Font.BOLD + Font.ITALIC, 54));
            g.setColor(Color.BLACK);
            printSimpleString("PAUSED",getWidth(), -3,getHeight()/2 - 5,g);
            g.setColor(Color.RED);
            printSimpleString("PAUSED",getWidth(), 0,getHeight()/2,g);
        }
        if(Stats.isEnd()){
            g.setFont(new Font("comic sans ms", Font.BOLD, 96));
            g.setColor(Color.CYAN);
            printSimpleString("GAME OVER", getWidth(), 0 , getHeight()/2, g);
            g.setFont(new Font("comic sans ms", Font.PLAIN, 36));
            printSimpleString("Final Score: " + Stats.getScore(), getWidth(), 0, (getHeight()/2)+50, g);
            printSimpleString("Press [SPACE] to play again!", getWidth(), 0, (getHeight()/2)+100, g );
        }
    }

    private void printSimpleString(String s, int width, int XPos, int YPos, Graphics g2d){
        int stringLen = (int)g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();
        int start = width/2 - stringLen/2;
        g2d.drawString(s, start + XPos, YPos);
    }

    public int getNextEntity(){
        return entities.size();
    }

    public Rectangle getHitbox(int index){
        return entities.get(index).getBounds();
    }

    public void removeEntity(int index){
        entities.remove(index);
        for(int i = index; i < entities.size(); i++){
            entities.get(i).decrementIndex();
        }
    }
    public void addEntity(Entity e){
        entities.add(e);
    }



    public Entity getEntity(int index){
        return entities.get(index);
    }

    public boolean isAPressed(){
        return aPressed;
    }

    public boolean isDPressed(){
        return dPressed;
    }

    public boolean isSpacePressed() {
        return spacePressed;
    }
    public boolean isLClick(){
        return lClick;}

}
