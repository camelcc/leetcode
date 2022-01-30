import java.util.ArrayList;
import java.util.List;

public class S2155AllDivisionsWithHighestScoreBinaryArray {
    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> res = new ArrayList();
        int sum = 0;
        int right = 0;
        for (int n : nums) {
            right += n;
        }
        int left = 0;
        int N = nums.length;
        for (int i = 0; i <= N; i++) {
            int s = left+right;
            if (s == sum) {
                res.add(i);
            } else if (s > sum) {
                sum = s;
                res = new ArrayList();
                res.add(i);
            }
            if (i == N) {
                break;
            }
            right -= nums[i];
            left += (1-nums[i]);
        }

        return res;
    }
}
