import java.util.HashMap;

public class GameStatsAggregate {
    public static HashMap<Integer, Integer> getResultPairs(int[] BIN_EDGES, GameStats stats){
        HashMap<Integer, Integer> pairMap = new HashMap<>();
        for(int binIndex=0; binIndex<BIN_EDGES.length; binIndex++){
            pairMap.put(binIndex, sumResults(BIN_EDGES, binIndex, stats));
        }
        return pairMap;
    }

    public static int sumResults(int[] BIN_EDGES, int binIndex, GameStats stats) {
        final int lowerBound = BIN_EDGES[binIndex];
        int numGames = 0;

        if (binIndex == BIN_EDGES.length-1) {
            for (int numGuesses=lowerBound; numGuesses < stats.maxNumGuesses(); numGuesses++) {
                numGames += stats.numGames(numGuesses);
            }
        } else {
            int upperBound = BIN_EDGES[binIndex+1];
            for (int numGuesses=lowerBound; numGuesses <= upperBound; numGuesses++) {
                numGames += stats.numGames(numGuesses);
            }
        }

        return  numGames;
    }
}
