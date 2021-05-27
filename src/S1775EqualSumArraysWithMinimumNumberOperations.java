public class S1775EqualSumArraysWithMinimumNumberOperations {
    public int minOperations(int[] nums1, int[] nums2) {
        int[] cnt1 = new int[7], cnt2 = new int[7];
        int sum1 = 0, sum2 = 0;
        for (int n : nums1) {
            cnt1[n]++;
            sum1 += n;
        }
        for (int n : nums2) {
            cnt2[n]++;
            sum2 += n;
        }
        if (sum1 > sum2) {
            int[] t = cnt1;
            cnt1 = cnt2;
            cnt2 = t;
        }
        int gap = Math.abs(sum1-sum2);
        int res = 0;
        for (int i = 1; i < 6; i++) {
            int dice = cnt1[i]+cnt2[7-i];
            int up = 6-i;
            if (gap <= dice*up) {
                res += (gap+up-1)/up;
                return res;
            }
            gap -= dice*up;
            res += dice;
        }
        return -1;
    }
}
