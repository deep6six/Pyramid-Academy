package program;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest
{
    Hangman test;

    @BeforeEach
    void constructTest()
    {
        test = new Hangman();
    }

    @Test
    void invalidCh_true()
    {
        test.guess = "0";
        assertEquals(true, test.invalidCh());
    }

    @Test
    void gameState_false()
    {
        test.word = "test";
        assertEquals(false, test.gameState());
    }
}