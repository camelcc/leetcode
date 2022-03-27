public class S2216MinimumDeletionsMakeArrayBeautiful {
    public int minDeletion(int[] nums) {
        int skip2 = 0, skip1 = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            int res = Math.min(1+skip1, 2+skip2);
            if (nums[i] != nums[i+1]) {
                res = Math.min(res, skip2);
            }
            skip2 = skip1;
            skip1 = res;
        }
        return skip1;
    }
}
