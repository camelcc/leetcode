import java.util.HashMap;

public class S2190MostFrequentNumberFollowingKeyArray {
    public int mostFrequent(int[] nums, int key) {
        int target = 0, c = 0;
        HashMap<Integer, Integer> cnt = new HashMap();
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == key) {
                int t = nums[i+1];
                int tc = cnt.getOrDefault(t, 0)+1;
                cnt.put(t, tc);
                if (tc > c) {
                    c = tc;
                    target = t;
                }
            }
        }
        return target;
    }
}
