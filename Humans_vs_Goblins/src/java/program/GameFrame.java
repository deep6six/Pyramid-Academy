package program;
import javax.swing.*;

public class GameFrame extends JFrame
{
    GameFrame()
    {
        this.add(new Game());
        this.setTitle("Humans vs Goblins");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
