package program;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Treasure
{
    Map<String,Integer> item = new HashMap<>();
    int x, y;

    public Treasure()
    {
        lootRoll();
        this.x = ThreadLocalRandom.current().nextInt(0, 24) * Game.UNIT_SIZE;
        this.y = ThreadLocalRandom.current().nextInt(1, 25) * Game.UNIT_SIZE;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public void lootRoll()
    {
        int r = ThreadLocalRandom.current().nextInt(1, 5);
        switch (r)
        {
            case 1: item.put("Steroids", 3); break;
            case 2: item.put("Beer", 1); break;
            case 3: item.put("Tea", 10); break;
            case 4: item.put("Coffee", 2); break;
        }
    }

    public String toString()
    {
        return "⚂";
    }

}
