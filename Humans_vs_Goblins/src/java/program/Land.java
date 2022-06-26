package program;
import java.util.ArrayList;

public class Land
{
    int population = 15;
    Human player = new Human();
    ArrayList<Goblin> spawns = new ArrayList<>();
    ArrayList<Treasure> chests = new ArrayList<>();

    Land()
    {
        for (int i = 0; i < population; i++) { spawns.add(new Goblin()); }
    }
    public void respawn()
    {
        if (spawns.size() < population) { spawns.add(new Goblin()); }
    }

    public void generateLoot()
    {
        chests.add(new Treasure());
    }
}
