public class S1671MinimumNumberRemovalsMakeMountainArray {
    public int minimumMountainRemovals(int[] nums) {
        int[] min = new int[nums.length];
        min[0] = -1;
        for (int i = 0; i < nums.length; i++) {
            int r = -1;
            for (int j = i-1; j >= 0; j--) {
                if (r >= 0 && i-j-1 >= r) {
                    break;
                }
                if (nums[j] >= nums[i]) {
                    continue;
                }
                // candidate
                int t = 0;
                if (min[j] == -1) {
                    t = i-j-1+j;
                } else {
                    t = i-j-1+min[j];
                }
                if (r == -1) {
                    r = t;
                } else {
                    r = Math.min(r, t);
                }
            }
            min[i] = r;
        }
        int[] max = new int[nums.length];
        max[nums.length-1] = -1;
        for (int i = nums.length-2; i >= 0; i--) {
            int r = -1;
            for (int j = i+1; j < nums.length; j++) {
                if (r > 0 && j-i-1 >= r) {
                    break;
                }
                if (nums[j] >= nums[i]) {
                    continue;
                }
                // candidate
                int t = 0;
                if (max[j] == -1) {
                    t = j-i-1+Math.max(nums.length-1-j, 0);
                } else {
                    t = j-i-1+max[j];
                }
                if (r == -1) {
                    r = t;
                } else {
                    r = Math.min(r, t);
                }
            }
            max[i] = r;
        }
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (min[i] >= 0 && max[i] >= 0) {
                res = Math.min(res, min[i]+max[i]);
            }
        }
        return res;
    }
}

