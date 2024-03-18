import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.SortedMap;
import java.util.TreeMap;

public class StatsFileTest {

    @Test
    void numGames_NullMap() {
        StatsFileMock mock = new StatsFileMock(null);

        assertThrows(NullPointerException.class, () -> mock.numGames(0));
    }

    @Test
    void numGames_Zero() {
        SortedMap<Integer, Integer> mockMap = new TreeMap<>();
        mockMap.put(1, 0);

        StatsFileMock mock = new StatsFileMock(mockMap);

        assertEquals(0, mock.numGames(1));
    }

    @Test
    void numGames_Default() {
        SortedMap<Integer, Integer> mockMap = new TreeMap<>();
        StatsFileMock mock = new StatsFileMock(mockMap);

        assertEquals(0, mock.numGames(1));
    }

    @Test
    void numGames_NonZero() {
        SortedMap<Integer, Integer> mockMap = new TreeMap<>();
        mockMap.put(1, 10);
        StatsFileMock mock = new StatsFileMock(mockMap);


        assertEquals(10, mock.numGames(1));
    }

    @Test
    void maxNumGuesses_Empty() {
        SortedMap<Integer, Integer> mockMap = new TreeMap<>();
        StatsFileMock mock = new StatsFileMock(mockMap);

        assertEquals(0, mock.maxNumGuesses());
    }

    @Test
    void maxNumGuesses_MaxOne() {
        SortedMap<Integer, Integer> mockMap = new TreeMap<>();
        mockMap.put(1, 10);
        StatsFileMock mock = new StatsFileMock(mockMap);

        assertEquals(1, mock.maxNumGuesses());
    }

    @Test
    void maxNumGuesses_MaxMultiple() {
        SortedMap<Integer, Integer> mockMap = new TreeMap<>();
        mockMap.put(1, 10);
        mockMap.put(2, 5);
        StatsFileMock mock = new StatsFileMock(mockMap);

        assertEquals(2, mock.maxNumGuesses());
    }
}
