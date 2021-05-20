import java.util.HashMap;
import java.util.HashSet;

public class S1726TupleSameProduct {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, HashSet<Integer>> cnt = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int p = nums[i]*nums[j];
                cnt.putIfAbsent(p, new HashSet<>());
                cnt.get(p).add(i*nums.length+j);
            }
        }
        int res =0;
        for (HashSet<Integer> s : cnt.values()) {
            int c = s.size();
            res += c*(c-1)*4;
        }
        return res;
    }
}
