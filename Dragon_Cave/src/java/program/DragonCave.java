package program;
import java.util.Scanner;

public class DragonCave
{
    Scanner input = new Scanner(System.in);
    int choice, r;
    boolean c = false;

    public DragonCave()
    {
        r = (int)((Math.random() * 2) + 1);
    }

    public void game()
    {
        System.out.println("You are in a land full of dragons. In front of you, you see two caves. \n" +
                "In one cave, the dragon is friendly and will share his treasure with you.\n" +
                "The other dragon is greedy and hungry and will eat you on sight.\n"+
                "Which cave will you go into? (1 or 2)\n");
        choice();
        System.out.println(result());
    }

    public void choice()
    {
        do
        {
            try
            {
                choice = input.nextInt();
                if ( choice == 1 || choice == 2 ) { c = true; }
                else { System.out.println("Choose 1 or 2"); }
            } catch (Exception e) { System.out.println("I'm sorry, please choose 1 or 2"); input.next(); }
        } while(!c);
     }

    public String result()
    {
        String s = "";
        if ((choice - r) == 0)
        {
            s = "You approach the cave...\nIt is dark and spooky...\n" +
                "A large dragon greets you into his quarters! He opens " +
                "his refrigerator and...\n" + "Hands you a leftover pizza!";
        }
        else
        {
            s = "You approach the cave...\nIt is dark and spooky...\n" +
                    "A large dragon jumps out in front of you! He opens " +
                    "his jaws and...\n" + "Gobbles you down in one bite!";
        }
        return s;
    }
}