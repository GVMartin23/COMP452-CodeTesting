import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class ComputerGuessesPanelTests {
    @Test
    void makesCorrectGuess() {
    assertEquals(50, ComputerGuess.makeGuess(49, 51));
    }
    @Test
    void getsLowerGuessWhenLastGuessSmaller(){
        assertEquals(50, ComputerGuess.getLowerGuess(1000, 51));
    }
    @Test
    void getsLowerGuessWhenUpperBoundSmaller(){
        assertEquals(1000, ComputerGuess.getLowerGuess(1000, 10001));
    }
    @Test
    void getsHigherGuessWHenLastGuessLarger(){
        assertEquals(51, ComputerGuess.getHigherGuess(49, 50));
    }
    @Test
    void getsHigherGuessWhenLowerBoundsLarger(){
        assertEquals(45, ComputerGuess.getHigherGuess(45, 40));
    }
    @Test
    void getsNextGuessCorrectlySpreadByTwo(){
        assertEquals(50, ComputerGuess.makeGuess(51, 49));
    }
    @Test
    void getsNextGuessCorrectlySpreadByThree(){
        assertTrue(ComputerGuess.makeGuess(49, 52) > 49 && ComputerGuess.makeGuess(49, 52) <52);
    }
}
