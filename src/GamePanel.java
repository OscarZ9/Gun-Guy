import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable{
    Thread gameThread;
    int screenWidth = 1000;
    int screenHeight = 600;

    ArrayList<Ground> grounds = new ArrayList<>();

    KeyHandler keyHandler = new KeyHandler();
    Player player = new Player(keyHandler);

    public GamePanel(){
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        addKeyListener(keyHandler);
        setFocusable(true);
        grounds.add(new Ground(0, 450, 300, 150));
        grounds.add(new Ground(400, 450, 300, 150));
        grounds.add(new Ground(750, 450, 250, 150));

    }

    void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(135, 206, 235));
        g2d.fillRect(0, 0, screenWidth, screenHeight);
        player.draw(g2d);

        for (Ground ground : grounds){
            ground.draw(g2d);
        }
        g2d.dispose();
    }

    @Override
    public void run() {

        double intervalPerFrame = 1000000000 / 60.0;
        double actualTime = System.nanoTime();
        double nextFrame = actualTime + intervalPerFrame;

        while(true){
            if (System.nanoTime() >= nextFrame) {
                update();
                repaint();
                actualTime = System.nanoTime();
                nextFrame = actualTime + intervalPerFrame;
            }
        }
    }
    void update(){
        player.update();
    }
}
