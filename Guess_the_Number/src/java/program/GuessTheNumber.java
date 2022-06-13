package program;
import java.util.Scanner;


public class GuessTheNumber
{
    Scanner input = new Scanner(System.in);
    String pName;
    int counter, winCondition, r, guess;


    public GuessTheNumber(String pName, int winCondition)
    {
        this.pName = pName;
        this.winCondition = winCondition;
        this.counter = 0;
        this.r = (int)Math.floor(Math.random()*(20)+1);
    }

    public boolean game()
    {
        while (guess != r)
        {
            try
            {
            guess = input.nextInt();
            System.out.println(feedback());
            counter++;
            } catch (Exception e) { System.out.println(e + "\nTake a guess."); input.next();}
        }
        System.out.println(checkWin());
        return replay();
    }

    public String feedback()
    {
        String f = "";
        if (guess > r) { f = "Your guess is too high."; }
        else if (guess < r) { f = "Your guess is too low."; }
        return f;
    }

    public String checkWin()
    {
        String f = "";
        if (counter <= winCondition) { f = String.format("Good Job, " + pName + "! You guessed my number in " + counter + " guesses!"); }
        else if (counter > winCondition) { f = String.format("In order to win you need to guess correctly within " + winCondition + " tries!"); }
        return f;
    }

    public boolean replay()
    {
        System.out.println("\nWould you like to play again? (y or n)");
        String yn = "";

        while (!(yn.equalsIgnoreCase("y")) && !(yn.equalsIgnoreCase("n")))
        {
            try
            {
                yn = input.next().toLowerCase();
                if (!(yn.equalsIgnoreCase("y")) && !(yn.equalsIgnoreCase("n")))
                {
                    System.out.println("Enter 'y' or 'n'");
                }
            } catch (Exception e) { System.out.println(e); input.next(); }
        }
        if (yn.equalsIgnoreCase("y")) { return true; }
        else if (yn.equalsIgnoreCase("n")) { return false; }
        return false;
    }

}
