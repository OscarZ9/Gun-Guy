import java.awt.*;

public class Player{
    double horizontalPosition = 20;
    double verticalPosition = 350;
    int width = 60;
    int height = 80;
    double speed = 5;

    KeyHandler keyHandler;

    Player(KeyHandler keyHandler){
        this.keyHandler = keyHandler;
    }

    void draw(Graphics2D g2d){
        g2d.setColor(Color.BLACK);
        int horizontalPos = (int) horizontalPosition;
        int verticalPos = (int) verticalPosition;
        g2d.fillRect(horizontalPos, verticalPos, width, height);
    }

    void update(){
        if (keyHandler.leftPressed){
            horizontalPosition -= 5;
        }
        if (keyHandler.rightPressed){
            horizontalPosition += 5;
        }
        if (keyHandler.jumpPressed){
            verticalPosition -= 10;
        }
    }
}
