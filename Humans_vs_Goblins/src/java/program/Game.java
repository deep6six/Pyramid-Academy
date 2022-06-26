package program;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.ThreadLocalRandom;

public class Game extends JPanel implements ActionListener
{
    Land GoblinsVsHumans = new Land();
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int DELAY = 0;
    boolean running = false;
    Timer timer;

    Game()
    {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.green);
        this.setFocusable(true);
        this.addKeyListener(new kbHit());
        startGame();
    }

    public void startGame()
    {
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g)
    {
        if (running)
        {
            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++)
            {
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            }

            g.setFont(new Font("HvG", Font.CENTER_BASELINE, UNIT_SIZE));

            g.setColor(Color.blue);
            g.drawString(GoblinsVsHumans.player.toString(), GoblinsVsHumans.player.getX(), GoblinsVsHumans.player.getY());

            g.setColor(Color.red);
            for (int i = 0; i < GoblinsVsHumans.spawns.size(); i++)
            {
                g.drawString(GoblinsVsHumans.spawns.get(i).toString(), GoblinsVsHumans.spawns.get(i).getX(), GoblinsVsHumans.spawns.get(i).getY());
            }

            g.setColor(Color.magenta);
            for (int i = 0; i < GoblinsVsHumans.chests.size(); i++)
            {
                g.drawString(GoblinsVsHumans.chests.get(i).toString(), GoblinsVsHumans.chests.get(i).getX(), GoblinsVsHumans.chests.get(i).getY());
            }

        }
        else { gameOver(g); }
    }

    public void moveGoblins()
    {
        for (int i = 0; i < GoblinsVsHumans.spawns.size(); i++)
        {
            int move = ThreadLocalRandom.current().nextInt(1, 5);

            switch(move)
            {
                case 1: GoblinsVsHumans.spawns.get(i).setX(GoblinsVsHumans.spawns.get(i).getX() - UNIT_SIZE);
                    if (GoblinsVsHumans.spawns.get(i).getX() < 0 ) { GoblinsVsHumans.spawns.get(i).setX(575); } break;

                case 2: GoblinsVsHumans.spawns.get(i).setX(GoblinsVsHumans.spawns.get(i).getX() + UNIT_SIZE);
                    if (GoblinsVsHumans.spawns.get(i).getX() > 575) { GoblinsVsHumans.spawns.get(i).setX(0); } break;

                case 3: GoblinsVsHumans.spawns.get(i).setY(GoblinsVsHumans.spawns.get(i).getY() - UNIT_SIZE);
                    if (GoblinsVsHumans.spawns.get(i).getY() < 25) { GoblinsVsHumans.spawns.get(i).setY(600); } break;

                case 4: GoblinsVsHumans.spawns.get(i).setY(GoblinsVsHumans.spawns.get(i).getY() + UNIT_SIZE);
                    if (GoblinsVsHumans.spawns.get(i).getY() > 600) { GoblinsVsHumans.spawns.get(i).setY(25); } break;
            }
        }
    }

    public void checkTile()
    {
        for (int i = 0; i < GoblinsVsHumans.chests.size(); i++)
        {
            if (GoblinsVsHumans.player.getX() == GoblinsVsHumans.chests.get(i).getX() &&
                    GoblinsVsHumans.player.getY() == GoblinsVsHumans.chests.get(i).getY())
            {
                GoblinsVsHumans.player.inventory.add(GoblinsVsHumans.chests.get(i).item);
                GoblinsVsHumans.player.statMod();
                GoblinsVsHumans.chests.remove(i);
            }
        }
        for (int i = 0; i < GoblinsVsHumans.spawns.size(); i++)
        {
            if ((GoblinsVsHumans.player.getX() == GoblinsVsHumans.spawns.get(i).getX() &&
                    GoblinsVsHumans.player.getY() == GoblinsVsHumans.spawns.get(i).getY()) ||
                    (GoblinsVsHumans.player.getY() == GoblinsVsHumans.spawns.get(i).getY() &&
                    GoblinsVsHumans.player.getX() + UNIT_SIZE == GoblinsVsHumans.spawns.get(i).getX()) ||
                    (GoblinsVsHumans.player.getY() == GoblinsVsHumans.spawns.get(i).getY() &&
                    GoblinsVsHumans.player.getX() - UNIT_SIZE == GoblinsVsHumans.spawns.get(i).getX()) ||
                    (GoblinsVsHumans.player.getX() == GoblinsVsHumans.spawns.get(i).getX() &&
                    GoblinsVsHumans.player.getY() + UNIT_SIZE == GoblinsVsHumans.spawns.get(i).getY()) ||
                    (GoblinsVsHumans.player.getX() == GoblinsVsHumans.spawns.get(i).getX() &&
                    GoblinsVsHumans.player.getY() - UNIT_SIZE == GoblinsVsHumans.spawns.get(i).getY()))
            {
                battle(GoblinsVsHumans.player, GoblinsVsHumans.spawns.get(i));
            }
        }
    }

    public void battle(Human p, Goblin g)
    {
        System.out.println("Commence Battle");

        while(true)
        {
            if (p.getSpd() > g.getSpd())
            {
                g.setHp(g.getHp() - (p.getAtk() - g.getDef()));
                System.out.println("You hit the goblin for " + (p.getAtk() - g.getDef()) + " damage.");
                if(g.getHp() <= 0)
                {
                    System.out.println("Goblin died.");
                    GoblinsVsHumans.spawns.remove(g);
                    GoblinsVsHumans.generateLoot();
                    break;
                }

                p.setHp(p.getHp() - (g.getAtk() - p.getDef()));
                System.out.println("Goblin hit you for " + (g.getAtk() - p.getDef()) + " damage");
                if (p.getHp() <= 0) { System.out.println("You died"); running = false; break; }
            }
            else
            {
                p.setHp(p.getHp() - (g.getAtk() - p.getDef()));
                System.out.println("Goblin hit you for " + (g.getAtk() - p.getDef()) + " damage");
                if (p.getHp() <= 0) { System.out.println("You died"); running = false; break; }

                g.setHp(g.getHp() - (p.getAtk() - g.getDef()));
                System.out.println("You hit the goblin for " + (p.getAtk() - g.getDef()) + " damage.");
                if (g.getHp() <= 0)
                {
                    System.out.println("Goblin died.");
                    GoblinsVsHumans.spawns.remove(g);
                    GoblinsVsHumans.generateLoot();
                    break;
                }
            }
        }
    }

    public void gameOver(Graphics g)
    {
        g.setColor(Color.black);
        g.setFont( new Font("GameOver",Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("GAMEOVER", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(running)
        {
            checkTile();
            GoblinsVsHumans.respawn();
        }
        repaint();
    }

    public class kbHit extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            switch(e.getKeyCode())
            {
                case KeyEvent.VK_LEFT:
                    GoblinsVsHumans.player.setX(GoblinsVsHumans.player.getX() - UNIT_SIZE); moveGoblins();
                    if (GoblinsVsHumans.player.getX() < 0) { GoblinsVsHumans.player.setX(575); } break;

                case KeyEvent.VK_RIGHT:
                    GoblinsVsHumans.player.setX(GoblinsVsHumans.player.getX() + UNIT_SIZE); moveGoblins();
                    if (GoblinsVsHumans.player.getX() > 575) { GoblinsVsHumans.player.setX(0);} break;

                case KeyEvent.VK_UP:
                    GoblinsVsHumans.player.setY(GoblinsVsHumans.player.getY() - UNIT_SIZE); moveGoblins();
                    if (GoblinsVsHumans.player.getY() < 25) { GoblinsVsHumans.player.setY(600); } break;

                case KeyEvent.VK_DOWN:
                    GoblinsVsHumans.player.setY(GoblinsVsHumans.player.getY() + UNIT_SIZE); moveGoblins();
                    if (GoblinsVsHumans.player.getY() > 600) { GoblinsVsHumans.player.setY(25); } break;
            }
        }
    }
}

