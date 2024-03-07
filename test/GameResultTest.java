import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    @org.junit.jupiter.api.Test
    void getAnswerValueString() {
        GameResult gameResult = new GameResult(true, 10, 5);
        assertEquals("The answer was 10.", gameResult.getAnswerValueString());
    }

    @org.junit.jupiter.api.Test
    void getNumGuessesString_FirstPlayer() {
        GameResult gameResult = new GameResult(true, 50, 1);
        assertEquals("You guessed it on the first try!", gameResult.getNumGuessesString());
    }

    @org.junit.jupiter.api.Test
    void getNumGuessesString_LaterPlayer() {
        GameResult gameResult = new GameResult(true, 50, 10);
        assertEquals("It took you 10 guesses.", gameResult.getNumGuessesString());
    }

    @org.junit.jupiter.api.Test
    void getNumGuessesString_FirstComputer() {
        GameResult gameResult = new GameResult(false, 50, 1);
        assertEquals("I guessed it on the first try!", gameResult.getNumGuessesString());
    }

    @org.junit.jupiter.api.Test
    void getNumGuessesString_LaterComputer() {
        GameResult gameResult = new GameResult(false, 50, 10);
        assertEquals("It took me 10 guesses.", gameResult.getNumGuessesString());
    }
}