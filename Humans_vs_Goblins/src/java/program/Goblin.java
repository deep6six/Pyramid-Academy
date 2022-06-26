package program;
import java.util.concurrent.ThreadLocalRandom;

public class Goblin extends Humanoid
{
    public Goblin()
    {
        this.hp = ThreadLocalRandom.current().nextInt(30, 51);
        this.def = ThreadLocalRandom.current().nextInt(0, 6);
        this.atk = ThreadLocalRandom.current().nextInt(7, 13);
        this.spd = ThreadLocalRandom.current().nextInt(10, 21);
    }

    @Override
    public String toString() { return "\uD83D\uDC7A"; }
}
