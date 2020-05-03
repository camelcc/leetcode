public class S1437CheckAll1AreLeastLengthKPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {
        if (k == 0) {
            return true;
        }
        int pos = 0-k-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                continue;
            }
            int d = i-pos-1;
            if (d < k) {
                return false;
            }
            pos = i;
        }
        return true;
    }
}
