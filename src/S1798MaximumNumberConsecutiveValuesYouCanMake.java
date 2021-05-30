import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class S1798MaximumNumberConsecutiveValuesYouCanMake {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int min = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int c : coins) {
            if (min+1-c < 0) {
                return min+1;
            }
            min += c;
            for (int v : new ArrayList<>(set)) {
                set.add(v+c);
            }
            while (!set.isEmpty() && set.first() <= min) {
                set.remove(set.first());
            }
            while (set.contains(min+1)) {
                set.remove(min+1);
                min++;
            }
        }
        return min+1;
    }
}
