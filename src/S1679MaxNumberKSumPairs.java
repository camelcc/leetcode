import java.util.Arrays;
import java.util.HashMap;

public class S1679MaxNumberKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (v <= k/2) {
                cnt.put(v, cnt.getOrDefault(v, 0)+1);
            } else { // v > k/2
                if (cnt.containsKey(k-v)) {
                    int c = cnt.get(k-v);
                    c--;
                    res++;
                    if (c == 0) {
                        cnt.remove(k-v);
                    } else {
                        cnt.put(k-v, c);
                    }
                }
            }
        }
        if (k%2 == 0) {
            res = res + cnt.getOrDefault(k/2, 0)/2;
        }
        return res;
    }
}
