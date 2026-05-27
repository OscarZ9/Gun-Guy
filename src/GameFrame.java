import javax.swing.JFrame;

public class GameFrame extends JFrame{
    GameFrame(){
        setTitle("Gun Guy");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel gamePanel = new GamePanel();
        add(gamePanel);
        gamePanel.startGameLoop();

        pack();
        setLocationRelativeTo(null);

        setVisible(true);
    }



}