package program;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DragonCaveTest
{
    DragonCave test;

    @BeforeEach
    void constructTest()
    {
        test = new DragonCave();
    }

    @Test
    void Dialog_WrongGuess()
    {
        test.choice = 1;
        test.r = 2;
        assertEquals("You approach the cave...\nIt is dark and spooky...\n" +
                "A large dragon jumps out in front of you! He opens " +
                "his jaws and...\n" + "Gobbles you down in one bite!", test.result());
    }

    @Test
    void Dialog_RightGuess()
    {
        test.choice = test.r;
        assertEquals("You approach the cave...\nIt is dark and spooky...\n" +
                "A large dragon greets you into his quarters! He opens " +
                "his refrigerator and...\n" + "Hands you a leftover pizza!", test.result());
    }
}