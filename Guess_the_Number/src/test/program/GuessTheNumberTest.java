package program;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessTheNumberTest
{
    GuessTheNumber test;
    int winCondition = 6;

    @BeforeEach
    void constructTest()
    {
        test = new GuessTheNumber("Test", winCondition);
    }


    @Test
    void feedback_high()
    {
        test.guess = 15;
        test.r = 10;
        assertEquals("Your guess is too high.",test.feedback());
    }

    @Test
    void checkWin_lose()
    {
        test.counter = 10;
        assertEquals(String.format("In order to win you need to guess correctly within " + winCondition + " tries!"),test.checkWin());
    }
}