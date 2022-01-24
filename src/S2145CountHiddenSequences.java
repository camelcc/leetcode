public class S2145CountHiddenSequences {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = 0, max = 0, sum = 0;
        for (int d : differences) {
            sum += d;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        long diff = max-min;
        long maxLower = upper-diff;
        return (int)Math.max(0, maxLower-lower+1);
    }
}
