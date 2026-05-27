import java.awt.*;

public class Ground {
    int xPosition = 0;
    int yPosition = 450;
    int width = 500;
    int height = 150;

    Ground(int xPosition, int yPosition, int width, int height){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
    }

    void draw(Graphics2D g2d){
        g2d.setColor(Color.BLACK);
        g2d.fillRect(xPosition, yPosition, width, height);
    }
}
