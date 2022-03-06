import java.util.HashSet;

public class S2195AppendKIntegersWithMinimalSum {
    public long minimalKSum(int[] nums, int k) {
        HashSet<Integer> visited = new HashSet<>();
        int next = k+1;
        long res = ((long)k)*(k+1)/2;
        for (int n : nums) {
            if (visited.contains(n)) {
                continue;
            }
            if (n < next) {
                while (visited.contains(next)) {
                    next++;
                }
                res -= n;
                res += next++;
            }
            visited.add(n);
        }
        return res;
    }
}
