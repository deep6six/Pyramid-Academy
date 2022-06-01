import java.util.Scanner;

public class GuessTheNumber
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello! What is your name?");
        String pName = input.next();

        boolean replay = false;
        do
        {
            int r = (int)Math.floor(Math.random()*(20)+1);
            System.out.println("\nWell, " + pName + ", I am thinking of a number between 1 and 20.\n" + "Take a guess.");
            int guess = 0, counter = 0;
            do
            {
                guess = input.nextInt();
                if (guess > r) { System.out.println("Your guess is too high."); }
                else if (guess < r) { System.out.println("Your guess is too low."); }
                counter++;
            } while (guess != r);
            if (counter <= 6){ System.out.println("Good Job, " + pName + "! You guess my number in " + counter + " guesses!");}
            else if (counter > 6) { System.out.println( "In order to win you need to guess correctly within 6 tries!"); }

            System.out.println("\nWould you like to play again? (y or n)");
            String yn;
            do
            {
                yn = input.next().toLowerCase();
                if (!(yn.equalsIgnoreCase("y")) && !(yn.equalsIgnoreCase("n")))
                {
                    System.out.println("Enter 'y' or 'n'");
                }
            } while (!(yn.equalsIgnoreCase("y")) && !(yn.equalsIgnoreCase("n")));

            if (yn.equalsIgnoreCase("y")) { replay = true; }
            if (yn.equalsIgnoreCase("n")) { replay = false; }
        } while (replay);
        System.exit(0);
    }
}
