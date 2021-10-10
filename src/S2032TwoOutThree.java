import java.util.ArrayList;
import java.util.List;

public class S2032TwoOutThree {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] cnt = new int[101];
        for (int n : nums1) {
            cnt[n] |= 0x1;
        }
        for (int n : nums2) {
            cnt[n] |= 0x2;
        }
        for (int n : nums3) {
            cnt[n] |= 0x4;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 7 || cnt[i] == 3 || cnt[i] == 5 || cnt[i] == 6) {
                res.add(i);
            }
        }
        return res;
    }
}
