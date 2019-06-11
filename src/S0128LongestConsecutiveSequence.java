import java.util.HashMap;
import java.util.HashSet;

public class S0128LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (pos.containsKey(v)) {
                continue;
            }
            pos.put(v, i);
        }

        int[] uf = new int[nums.length];
        HashSet<Integer> tails = new HashSet<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            uf[i] = i;
            int v = nums[i];
            if (pos.containsKey(v - 1)) {
                uf[i] = pos.get(v - 1);
                tails.remove(pos.get(v - 1));
            }
            if (pos.containsKey(v + 1)) {
                uf[pos.get(v + 1)] = i;
            } else {
                tails.add(i);
            }
        }
        for (int tail : tails) {
            int len = 1;
            while (uf[tail] != tail) {
                len++;
                tail = uf[tail];
            }
            res = Math.max(res, len);
        }
        return res;
    }
}
