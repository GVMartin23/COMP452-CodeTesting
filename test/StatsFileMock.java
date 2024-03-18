import java.util.SortedMap;

/**
 * Mock Class for StatsFile
 */
public class StatsFileMock extends StatsFile{
    /**
     * Replaces StatsFile statsMap with dummy data
     * @param statsMap SortedMap with dummy data
     */
    public StatsFileMock(SortedMap<Integer, Integer> statsMap) {
        super();
        this.statsMap = statsMap;
    }
}
