import java.util.Scanner;

public class DragonCave
{
    public static void main(String[] args)
    {
        System.out.println("You are in a land full of dragons. In front of you,\n" +
                "you see two caves. In one cave, the dragon is friendly\n" +
                "and will share his treasure with you. The other dragon\n" +
                "is greedy and hungry and will eat you on sight.\n" +
                "\nWhich cave will you go into? (1 or 2)");

        Scanner input = new Scanner(System.in);
        int choice;

        do
        {
            choice = input.nextInt();
            if(choice > 2 || choice < 1) { System.out.println("Choose 1 or 2"); }
        } while (choice > 2 || choice < 1);

        switch(choice)
        {
            case 1: System.out.println("You approach the cave...\nIt is dark and spooky...\n" +
                    "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                    "Gobbles you down in one bite!"); break;
            case 2: System.out.println("You approach the cave...\nIt is dark and spooky...\n" +
                    "A large dragon greets you into his quarters! He opens his refrigerator and...\n" +
                    "Hands you a leftover pizza!"); break;
        }

        System.exit(0);
    }
}
