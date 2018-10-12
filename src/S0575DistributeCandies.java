import java.util.HashSet;

public class S0575DistributeCandies {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> kinds = new HashSet<>();
        for (int c : candies) {
            kinds.add(c);
        }
        int half = candies.length/2;
        return Math.min(kinds.size(), half);
    }
}
