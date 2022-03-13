import java.util.ArrayList;
import java.util.List;

public class S2200FindAllKDistantIndicesArray {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != key) {
                continue;
            }
            int lo = Math.max(0, i-k), hi = Math.min(i+k, nums.length-1);
            if (!res.isEmpty()) {
                lo = Math.max(res.get(res.size()-1)+1, lo);
            }
            for (int j = lo; j <= hi; j++) {
                res.add(j);
            }
            if (hi == nums.length-1) {
                break;
            }
        }
        return res;
    }
}
