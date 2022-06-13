package program;
import java.util.Scanner;


public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello! What's your name?");
        String pName = input.next();
        int winCondition = 6;
        boolean replay = false;

        do
        {
            GuessTheNumber play = new GuessTheNumber(pName, winCondition);
            System.out.println("\nWell, " + pName + ", I am thinking of a number between 1 and 20.\n" + "Take a guess.");
            replay = play.game();
        } while(replay);
    }
}
