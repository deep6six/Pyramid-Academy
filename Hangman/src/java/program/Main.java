package program;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        boolean replay = false;
        System.out.println("  H A N G M A N  ");

        do
        {
            Hangman play = new Hangman();
            replay = play.Game();
        } while(replay);
    }
}