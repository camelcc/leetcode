import java.util.HashMap;

public class S0506RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            pos.put(nums[i], i);
        }
        sort(nums);
        String[] res = new String[nums.length];
        if (nums.length > 0) {
            res[pos.get(nums[0])] = "Gold Medal";
        }
        if (nums.length > 1) {
            res[pos.get(nums[1])] = "Silver Medal";
        }
        if (nums.length > 2) {
            res[pos.get(nums[2])] = "Bronze Medal";
        }
        for (int i = 3; i < nums.length; i++) {
            int p = pos.get(nums[i]);
            res[p] = String.valueOf(i+1);
        }
        return res;
    }

    private void sort(int[] nums) {
        int[] aux = new int[nums.length];
        sort(nums, aux, 0, nums.length-1);
    }

    private void sort(int[] nums, int[] aux, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = (lo+hi)/2;
        sort(nums, aux, lo, mid);
        sort(nums, aux, mid+1, hi);
        merge(nums, aux, lo, mid, hi);
    }

    private void merge(int[] nums, int[] aux, int lo, int mid, int hi) {
        if (lo >= hi) {
            return;
        }
        for (int i = lo; i <= hi; i++) {
            aux[i] = nums[i];
        }
        int left = lo, right = mid+1, i = lo;
        while (left <= mid && right <= hi) {
            if (aux[left] > aux[right]) {
                nums[i++] = aux[left++];
            } else {
                nums[i++] = aux[right++];
            }
        }
        while (left <= mid) {
            nums[i++] = aux[left++];
        }
        while (right <= hi) {
            nums[i++] = aux[right++];
        }
    }
}
