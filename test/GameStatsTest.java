import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.SortedMap;
import java.util.TreeMap;

public class GameStatsTest {
    @Test
    void getResultPairs_Empty() {
        SortedMap<Integer, Integer> mockMap = new TreeMap<>();
        mockMap.put(1, 10);
        mockMap.put(2, 5);
        StatsFileMock mock = new StatsFileMock(mockMap);
    }

    @Test
    void getResultPairs_One() {
        SortedMap<Integer, Integer> mockMap = new TreeMap<>();
        mockMap.put(1, 10);
        mockMap.put(2, 5);
        StatsFileMock mock = new StatsFileMock(mockMap);
    }

    @Test
    void getResultPairs_Many() {
        SortedMap<Integer, Integer> mockMap = new TreeMap<>();
        mockMap.put(1, 10);
        mockMap.put(2, 5);
        StatsFileMock mock = new StatsFileMock(mockMap);
    }

    @Test
    void sumResults_Last() {
        SortedMap<Integer, Integer> mockMap = new TreeMap<>();
        mockMap.put(1, 10);
        mockMap.put(2, 5);
        StatsFileMock mock = new StatsFileMock(mockMap);
    }

    @Test
    void sumResults_First() {
        SortedMap<Integer, Integer> mockMap = new TreeMap<>();
        mockMap.put(1, 10);
        mockMap.put(2, 5);
        StatsFileMock mock = new StatsFileMock(mockMap);
    }

    @Test
    void sumResults_Many() {
        SortedMap<Integer, Integer> mockMap = new TreeMap<>();
        mockMap.put(1, 10);
        mockMap.put(2, 5);
        StatsFileMock mock = new StatsFileMock(mockMap);
    }

    @Test
    void sumResults_Middle() {
        SortedMap<Integer, Integer> mockMap = new TreeMap<>();
        mockMap.put(1, 10);
        mockMap.put(2, 5);
        StatsFileMock mock = new StatsFileMock(mockMap);
    }
}
