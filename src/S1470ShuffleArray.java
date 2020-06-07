public class S1470ShuffleArray {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];

        int li = 0, ri = n, i = 0;
        while (li < n) {
            res[i++] = nums[li++];
            res[i++] = nums[ri++];
        }
        return res;
    }
}
