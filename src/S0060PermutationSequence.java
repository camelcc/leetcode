import java.util.ArrayList;
import java.util.List;

public class S0060PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        int[] fac = new int[n];
        fac[0] = 1;
        for (int i = 1; i < n; i++) {
            fac[i] = i*fac[i-1];
        }
        k = k-1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int pos = k/fac[i-1];
            k = k%fac[i-1];
            sb.append(nums.get(pos));
            nums.remove(pos);
        }
        return sb.toString();
    }
}
