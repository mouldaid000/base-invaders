/**
 * Created by mouldaid000 on 3/2/2017.
 */
public class Stats{

    static int lives = 3, score = 0, health = 3;

    public static boolean menu = false, play = true, pause = false, end = false;

    public static boolean isMenu(){
        return menu;
    }
    public static boolean isPlay(){
        return play;
    }
    public static boolean isPause(){
        return pause;
    }
    public static boolean isEnd(){
        return end;
    }
    public static void togglePause(){
        if(pause){
            pause = false;
        }
        else pause = true;
    }
    public static void startPlay(){
        menu = false;
        play = true;
        pause = false;
        end = false;
    }

    public static void addScore() {
        score += 100;
    }
    public static int getHealth() {
        return health;
    }

    public static void setHealth(int health) {
        Stats.health = health;
    }
    public static int getScore(){
        return score;
    }
}