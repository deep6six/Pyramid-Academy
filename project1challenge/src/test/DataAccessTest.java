import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DataAccessTest {

    @Test
    void inputFileExists() {
        assertTrue(DataAccess.inputFileExists());
    }


    @Test
    void createInputFile() {
        assertTrue(DataAccess.createInputFile());
    }

    @Test
    void readInputFile() {
        ArrayList<String> input = new ArrayList<>(DataAccess.readInputFile());
        assertTrue(input.size() != 0);
    }

    @Test
    void fillInputFile() throws FileNotFoundException {
        assertTrue(DataAccess.fillInputFile());
    }
}