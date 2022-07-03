package program;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hangman
{
    Scanner input = new Scanner(System.in);
    String word, guess, name;
    int gCounter, score;
    ArrayList<Character> guesses = new ArrayList<>();
    HashSet<Character> wrongGuesses = new HashSet<>();

    public Hangman()
    {
        System.out.print("Enter your name: ");
        name = input.nextLine();
        System.out.println("  H A N G M A N  ");
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
        } catch (FileNotFoundException e) { e.printStackTrace(); System.exit(0); }
        Random r = new Random();
        return words.get(r.nextInt(words.size()));
    }

    public boolean game()
    {
        while (true)
        {
            printHangman();
            if (gCounter >= 6) { System.out.println("Hangman died. The secret word was '" + word + "'"); break; }
            if (gameState())
            {
                System.out.println("Yes the secret word is '" + word + "'! You have won");
                writeScore();
                break;
            }
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
            System.out.println("Invalid character"); return true;
        }

        if (guesses.contains(guess.charAt(0)))
        {
            System.out.println("You have already guessed that letter. Choose again."); return true;
        }
        return false;
    }

    public void printHangman()
    {
        Stream<String> hangman;
        try
        {
            hangman = Files.lines(Paths.get("C:\\Pyramid-Academy\\Hangman\\src\\java\\program\\HangmanTxt.txt"));
        } catch (IOException e) { e.printStackTrace(); throw new RuntimeException(e); }
        hangman.skip(gCounter*7).limit(7).forEach(System.out::println);
        System.out.println("Missed letters: " + wrongGuesses.toString());
    }

    public boolean gameState()
    {
        int correctCount = 0;

        for (int i = 0; i < word.length(); i++)
        {
            if (guesses.contains(word.charAt(i))) { System.out.print(word.charAt(i)); correctCount++; }
            else { System.out.print("-"); }
        }
        System.out.println();
        System.out.println();
        return (word.length() == correctCount);
    }

    public void writeScore()
    {
        score = 6 - gCounter;
        try
        {
            Files.writeString(Paths.get("C:\\Pyramid-Academy\\Hangman\\src\\java\\program\\scores.txt"),
                    String.format("%s %d\n", name, score), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) { e.printStackTrace(); throw new RuntimeException(e); }

        List<Integer> highScores;
        try
        {
            highScores = Files.lines(Paths.get("C:\\Pyramid-Academy\\Hangman\\src\\java\\program\\scores.txt"))
                    .map(line -> { String[] split = line.split(" "); return Integer.parseInt(split[1]); } )
                    .collect(Collectors.toList());
        } catch (IOException e) { e.printStackTrace(); throw new RuntimeException(e); }

        for (int i = 0; i < highScores.size(); i++)
        {
            if (score > highScores.get(i)) { System.out.println("Congratulations " + name + " you set a new high score!"); }
        }
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
            } catch (Exception e) { e.printStackTrace(); input.next(); }
        }
        if (yn.equalsIgnoreCase("y")) { return true; }
        else if (yn.equalsIgnoreCase("n")) { return false; }
        return false;
    }
}