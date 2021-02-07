public class S1523CountOddNumbersIntervalRange {
    public int countOdds(int low, int high) {
        if (low%2 == 0) {
            return countOdds(low+1, high);
        }
        if (low > high) {
            return 0;
        } else if (low == high) {
            return 1;
        }
        // low < high, low is odd
        if (high%2 == 1) {
            return (high-low)/2 + 1;
        } else {
            return (high+1-low)/2;
        }
    }
}
