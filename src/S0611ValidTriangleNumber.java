import java.util.Arrays;

public class S0611ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = nums.length-1; i >= 2; i--) {
            int j = 0, k = i-1;
            while (j < k) {
                if (nums[j]+nums[k] > nums[i]) {
                    cnt += k-j;
                    k--;
                } else {
                    j++;
                }
            }
        }
        return cnt;
    }
}
