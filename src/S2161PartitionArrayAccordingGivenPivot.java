public class S2161PartitionArrayAccordingGivenPivot {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        int p = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                res[p++] = nums[i];
            } else if (nums[i] == pivot) {
                cnt++;
            }
        }
        while (cnt > 0) {
            res[p++] = pivot;
            cnt--;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pivot) {
                res[p++] = nums[i];
            }
        }
        return res;
    }
}
