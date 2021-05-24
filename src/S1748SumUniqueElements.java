import java.util.HashSet;

public class S1748SumUniqueElements {
    public int sumOfUnique(int[] nums) {
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> unique = new HashSet<>();
        int res = 0;
        for (int n : nums) {
            if (visited.contains(n)) {
                continue;
            }
            if (unique.contains(n)) {
                unique.remove(n);
                res -= n;
                visited.add(n);
                continue;
            }
            unique.add(n);
            res += n;
        }
        return res;
    }
}
