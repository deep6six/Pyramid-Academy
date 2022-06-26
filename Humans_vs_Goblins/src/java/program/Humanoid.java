package program;
import java.util.concurrent.ThreadLocalRandom;

public class Humanoid
{
    int x, y, hp, def, atk, spd;

    public Humanoid()
    {
        this.x = ThreadLocalRandom.current().nextInt(0, 24) * Game.UNIT_SIZE;
        this.y = ThreadLocalRandom.current().nextInt(1, 25) * Game.UNIT_SIZE;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getHp() { return this.hp; }
    public int getDef() { return this.def; }
    public int getAtk() { return this.atk; }
    public int getSpd() { return this.spd; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setHp(int hp) { this.hp = hp; }
    public void setDef(int def) { this.def = def; }
    public void setAtk(int atk) { this.atk = atk; }
    public void setSpd(int spd) { this.spd = spd; }
    public String toString() { return "O"; }
}

