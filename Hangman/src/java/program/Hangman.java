package program;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Hangman
{
    Scanner input = new Scanner(System.in);
    String word, guess;
    int gCounter;
    ArrayList<Character> guesses = new ArrayList<>();
    HashSet<Character> wrongGuesses = new HashSet<>();


    public Hangman()
    {
        word = assignWord().toUpperCase();
        guess = "";
        gCounter = 0;
    }

    public String assignWord()
    {
        ArrayList<String> words = new ArrayList<>();
        try
        {
            Scanner wordList = new Scanner(new File("C:\\Pyramid-Academy\\Hangman\\src\\java\\program\\commonWords.txt"));
            while (wordList.hasNext()) { words.add(wordList.nextLine()); }
        } catch (FileNotFoundException e) { System.out.println(e); System.exit(0); }
        Random r = new Random();
        return words.get(r.nextInt(words.size()));
    }

    public boolean Game()
    {
        while (true)
        {
            printHangman();
            if (gCounter >= 6) { System.out.println("Hangman died. The secret word was '" + word + "'"); break; }
            if (gameState()) { System.out.println("Yes the secret word is '" + word + "'! You have won"); break; }
            if (!getGuess()) { gCounter++; }
        }
        return replay();
    }

    public boolean getGuess()
    {
        do
        {
            System.out.println("Guess a letter");
            guess = input.nextLine().toUpperCase();
        } while (invalidCh());
        guesses.add(guess.charAt(0));

        if (!word.contains(guess)) { wrongGuesses.add(guess.charAt(0)); }
        return word.contains(guess);
    }

    public boolean invalidCh()
    {
        if (guess.contains("0") || guess.contains("1") || guess.contains("2") || guess.contains("3") || guess.contains("4") ||
                guess.contains("5") || guess.contains("6") || guess.contains("7") || guess.contains("8") || guess.contains("9"))
        {
            System.out.println("Invalid character");
            return true;
        }

        if (guesses.contains(guess.charAt(0)))
        {
            System.out.println("You have already guessed that letter. Choose again.");
            return true;
        }
        return false;
    }

    public void printHangman()
    {
        System.out.println("++======++");
        System.out.println(" |      ||");

        if (gCounter == 0)
        {
            System.out.println("        ||");
            System.out.println("        ||");
            System.out.println("        ||");
            System.out.println("        ||");
        }
        else if (gCounter == 1)
        {
            System.out.println(" O      ||");
            System.out.println("        ||");
            System.out.println("        ||");
            System.out.println("        ||");
        }
        else if (gCounter == 2)
        {
            System.out.println(" O      ||");
            System.out.println(" |      ||");
            System.out.println(" |      ||");
            System.out.println("        ||");
        }
        else if (gCounter == 3)
        {
            System.out.println(" O      ||");
            System.out.println("/|      ||");
            System.out.println(" |      ||");
            System.out.println("        ||");
        }
        else if (gCounter == 4)
        {
            System.out.println(" O      ||");
            System.out.println("/|\\     ||");
            System.out.println(" |      ||");
            System.out.println("        ||");
        }
        else if (gCounter == 5)
        {
            System.out.println(" O      ||");
            System.out.println("/|\\     ||");
            System.out.println(" |      ||");
            System.out.println("/       ||");
        }
        else if (gCounter == 6)
        {
            System.out.println(" O      ||");
            System.out.println("/|\\     ||");
            System.out.println(" |      ||");
            System.out.println("/ \\     ||");
        }
        System.out.println("===========");
        System.out.println("Missed letters: " + wrongGuesses.toString());
    }

    public boolean gameState()
    {
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++)
        {
            if (guesses.contains(word.charAt(i)))
            {
                System.out.print(word.charAt(i));
                correctCount++;
            }
            else { System.out.print("-"); }
        }
        System.out.println();
        System.out.println();
        return (word.length() == correctCount);
    }

    public boolean replay()
    {
        System.out.println("\nDo you want to play again? (y or n)");
        String yn = "";
        while (!(yn.equalsIgnoreCase("y")) && !(yn.equalsIgnoreCase("n")))
        {
            try
            {
                yn = input.next().toLowerCase();
                if (!(yn.equalsIgnoreCase("y")) && !(yn.equalsIgnoreCase("n")))
                { System.out.println("Enter 'y' or 'n'"); }
            } catch (Exception e) { System.out.println(e); input.next(); }
        }
        if (yn.equalsIgnoreCase("y")) { return true; }
        else if (yn.equalsIgnoreCase("n")) { return false; }
        return false;
    }
}