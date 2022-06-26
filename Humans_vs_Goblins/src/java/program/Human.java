package program;
import java.util.ArrayList;
import java.util.Map;

public class Human extends Humanoid
{
    ArrayList<Map<String,Integer>> inventory = new ArrayList<>();

    public Human()
    {
        this.hp = 100;
        this.def = 2;
        this.atk = 15;
        this.spd = 15;
    }

    public void statMod()
    {
        for (int i = 0; i < inventory.size(); i++)
        {
            for (String key: inventory.get(i).keySet())
            {
                if (inventory.get(i).get(key).equals(3))
                {
                    System.out.println("Acquired " + key + ". Atk increased by " + inventory.get(i).get(key));
                    this.setAtk(this.getAtk() + inventory.get(i).get(key));
                    inventory.remove(i); break;
                }
                if (inventory.get(i).get(key).equals(1))
                {
                    System.out.println("Acquired " + key + ". Def increased by " + inventory.get(i).get(key));
                    this.setDef(this.getDef() + inventory.get(i).get(key));
                    inventory.remove(i); break;
                }
                if (inventory.get(i).get(key).equals(10))
                {
                    System.out.println("Acquired " + key + ". HP increased by " + inventory.get(i).get(key));
                    this.setHp(this.getHp() + inventory.get(i).get(key));
                    inventory.remove(i); break;
                }
                if (inventory.get(i).get(key).equals(2))
                {
                    System.out.println("Acquired " + key + ". Spd increased by " + inventory.get(i).get(key));
                    this.setSpd(this.getSpd() + inventory.get(i).get(key));
                    inventory.remove(i); break;
                }
            }
        }
    }


    @Override
    public String toString() { return "\uD83E\uDD20"; }
}
