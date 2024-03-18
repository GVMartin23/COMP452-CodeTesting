public class ComputerGuess {
    public static int getHigherGuess(int lowerBound, int lastGuess){
        return Math.max(lowerBound, lastGuess + 1);
    }

    public static int getLowerGuess(int upperBound, int lastGuess){
        return Math.min(upperBound, lastGuess);
    }
    public static int makeGuess(int upperBound, int lowerBound){
        return (lowerBound + upperBound + 1) / 2;
    }
}
