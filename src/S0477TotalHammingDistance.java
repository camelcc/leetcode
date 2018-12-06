public class S0477TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int[] ones = new int[32];
        int[] zeros = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (0x1 << i)) == 0) {
                    zeros[i]++;
                } else {
                    ones[i]++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += ones[i]*zeros[i];
        }
        return res;
    }
}
