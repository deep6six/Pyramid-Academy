package program;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameFrameTest
{
    GameFrame test;

    @BeforeEach
    void constructTest()
    {
        test = new GameFrame();
    }

    @Test
    void programRuns()
    {
        assertNotNull(test);
    }

}