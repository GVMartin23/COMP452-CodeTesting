import javax.swing.*;
import java.util.HashMap;

/**
 * An interface for a data structure, DB API, file reader, etc. that
 * tells us how many games were played that took some number of guesses
 * (e.g., How many games took 8 guesses? --> 17)
 *
 * You can edit this file, but the two abstract methods listed below must remain
 */
public abstract class GameStats {
    /**
     * @return the number of games played that took numGuesses
     */
    public abstract int numGames(int numGuesses);

    /**
     * @return the maximum number of guesses that any game took
     */
    public abstract int maxNumGuesses();

    public HashMap<Integer, Integer> getResultPairs(int[] BIN_EDGES){
        HashMap<Integer, Integer> pairMap = new HashMap<>();
        for(int binIndex=0; binIndex<BIN_EDGES.length; binIndex++){
            final int lowerBound = BIN_EDGES[binIndex];
            int numGames = 0;

            if(binIndex == BIN_EDGES.length-1){
                // last bin
                // Sum all the results from lowerBound on up
                for(int numGuesses=lowerBound; numGuesses<maxNumGuesses(); numGuesses++){
                    numGames += numGames(numGuesses);
                }
            }
            else{
                int upperBound = BIN_EDGES[binIndex+1];
                for(int numGuesses=lowerBound; numGuesses <= upperBound; numGuesses++) {
                    numGames += numGames(numGuesses);
                }
            }
            pairMap.put(binIndex, numGames);
//            JLabel resultLabel = resultsLabels.get(binIndex);
//            resultLabel.setText(Integer.toString(numGames));
        }
        return pairMap;
    }
}
