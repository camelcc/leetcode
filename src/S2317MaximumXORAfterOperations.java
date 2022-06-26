import java.util.HashSet;

public class S2317MaximumXORAfterOperations {
    public int maximumXOR(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res = res | n;
        }
        return res;
    }
}
