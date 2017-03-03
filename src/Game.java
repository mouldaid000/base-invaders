import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by mouldaid000 on 3/1/2017.
 */
public class Game extends JPanel implements ActionListener{

    ArrayList<Entity> characters;
    ArrayList<Entity> bullets;

    static Timer timer;


    public boolean wPressed, aPressed, sPressed, dPressed, spacePressed, lClick;

    public static void main(String[] args){
        Game game = new Game();
        game.init();
        game.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
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
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
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

    public void init(){
        characters = new ArrayList<Entity>();
        characters.add(new Ship(Color.RED, getWidth()/2, getHeight()-25, 30, 30, this, 0));
        for(int i = 0; i < 6; i++){
            characters.add(new Alien(Color.GREEN, 25+i*3,25+i*3,12,12, this, characters.size()));
        }
    }
    public void start(){

    }
    public void collisions(){

    }
    public void paint(Graphics g){
        super.paint(g);
        if(Stats.isMenu()){
            g.setFont(new Font("comic sans ms", Font.BOLD, 72));
            g.setColor(Color.RED);
            printSimpleString("Base Invaders",getWidth(),0,(getHeight()/2)+50,g);

        }
    }
    private void printSimpleString(String s, int width, int XPos, int YPos, Graphics g2d){
        int stringLen = (int)g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();
        int start = width/2 - stringLen/2;
        g2d.drawString(s, start + XPos, YPos);
    }
    public boolean isWPressed(){
        return wPressed;
    }
    public boolean isAPressed(){
        return aPressed;
    }
    public boolean isSPressed(){
        return sPressed;
    }
    public boolean isDPressed(){
        return dPressed;
    }


}
