public class S0215KthElement {
    public int findKthLargest(int[] nums, int k) {
        int[] knum = new int[k];
        for (int i = 0; i < k; i++) {
            knum[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < nums.length; i++) {
            if (knum[k-1] >= nums[i]) {
                continue;
            }

            int pos = search(knum, nums[i]);
            for (int j = k - 1; j > pos; j--) {
                knum[j] = knum[j - 1];
            }
            knum[pos] = nums[i];
        }

        return knum[k-1];
    }

    private int search(int[] nums, int num) {
        int lo = 0, hi = nums.length-1;
        assert nums[hi] < num;

        while (lo < hi) {
            int mid = (lo + hi)/2;
            if (nums[mid] == num) {
                return mid;
            } else if (nums[mid] < num) {
                hi = mid;
            } else if (nums[mid] > num) {
                lo = mid+1;
            }
        }

        return lo;
    }
}
