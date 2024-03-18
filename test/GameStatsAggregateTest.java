import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * These tests will mostly fail simply due to the bug in the code, but the tests do what they are supposed to
 */
public class GameStatsAggregateTest {
    private final int [] BIN_EDGES = {1, 2, 4, 6, 8, 10, 12, 14};

    private HashMap<Integer, Integer> initResultsMap() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);
        map.put(7, 0);

        return new HashMap<>(map);
    }

    @Test
    void getResultPairs_Empty() {
        SortedMap<Integer, Integer> mockMap = new TreeMap<>();
        StatsFileMock mock = new StatsFileMock(mockMap);

        int[] empty = {};
        assertEquals(new HashMap<Integer, Integer>(), GameStatsAggregate.getResultPairs(empty, mock)); //using dependency injection
    }

    @Test
    void getResultPairs_One() {
        SortedMap<Integer, Integer> mockMap = new TreeMap<>();
        Map<Integer, Integer> resultsMap = initResultsMap();
        mockMap.put(1, 10);
        resultsMap.put(0, 10);// Range [1,1]
        StatsFileMock mock = new StatsFileMock(mockMap);

        assertEquals(resultsMap, GameStatsAggregate.getResultPairs(BIN_EDGES, mock)); //using dependency injection
    }

    @Test
    void getResultPairs_Many() {
        SortedMap<Integer, Integer> mockMap = new TreeMap<>();
        Map<Integer, Integer> resultsMap = initResultsMap();
        mockMap.put(1, 10);
        mockMap.put(2, 5);
        mockMap.put(3, 10);
        mockMap.put(4, 7);
        resultsMap.put(0, 10); //Range [1,1]
        resultsMap.put(1, 15); //Range [2,3]
        resultsMap.put(2, 7); //Range [4,5]
        StatsFileMock mock = new StatsFileMock(mockMap);

        //Will Fail due to but where Range is [2,4]
        //See Actual 1=22 when Expected 1=15 Range [2,3]
        assertEquals(resultsMap, GameStatsAggregate.getResultPairs(BIN_EDGES, mock)); //using dependency injection
    }

    @Test
    void sumResults_Last() {
        SortedMap<Integer, Integer> mockMap = new TreeMap<>();
        mockMap.put(1, 10);
        mockMap.put(2, 5);
        mockMap.put(14, 7);
        mockMap.put(15, 5);
        StatsFileMock mock = new StatsFileMock(mockMap);

        //These fail due to bug that we arent supposed to fix, I asked Wolfe
        assertEquals(12, GameStatsAggregate.sumResults(BIN_EDGES,BIN_EDGES.length-1, mock)); //using dependency injection
    }

    @Test
    void sumResults_First() {
        SortedMap<Integer, Integer> mockMap = new TreeMap<>();
        mockMap.put(1, 10);
        mockMap.put(2, 5);
        StatsFileMock mock = new StatsFileMock(mockMap);

        //These fail due to bug that we arent supposed to fix, I asked Wolfe
        assertEquals(10, GameStatsAggregate.sumResults(BIN_EDGES, 0, mock)); //using dependency injection
    }

    @Test
    void sumResults_Middle() {
        SortedMap<Integer, Integer> mockMap = new TreeMap<>();
        mockMap.put(1, 10);
        mockMap.put(3, 15);
        mockMap.put(2, 5);
        mockMap.put(4, 3);
        StatsFileMock mock = new StatsFileMock(mockMap);

        //These fail due to bug that we arent supposed to fix, I asked Wolfe
        assertEquals(20, GameStatsAggregate.sumResults(BIN_EDGES, 1, mock)); //using dependency injection
    }

    @Test
    void sumResults_Bounds() {
        SortedMap<Integer, Integer> mockMap = new TreeMap<>();
        mockMap.put(1, 10);
        mockMap.put(2, 5);
        mockMap.put(14, 7);
        StatsFileMock mock = new StatsFileMock(mockMap);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> GameStatsAggregate.sumResults(BIN_EDGES,BIN_EDGES.length, mock)); //using dependency injection
    }
}
