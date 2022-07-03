package program;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        boolean replay = false;

        do
        {
            Hangman play = new Hangman();
            replay = play.game();
        } while(replay);
    }
}