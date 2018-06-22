import java.util.ArrayList;
import java.util.List;

public class S0015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }

        sort(nums, 0, nums.length-1);
//        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            int first = nums[i];
            for (int j = i+1; j < nums.length-1; j++) {
                int second = nums[j];
                int pos = search(nums, j+1, nums.length-1, 0-first-second);
                if (pos != -1) {
                    List<Integer> match = new ArrayList<>();
                    match.add(first);
                    match.add(second);
                    match.add(nums[pos]);
                    res.add(match);
                }

                while (j < nums.length-1 && nums[j+1] == nums[j]) {
                    j++;
                }
            }

            while (i < nums.length-2 && nums[i+1] == nums[i]) {
                i++;
            }
        }

        return res;
    }

    private int search(int[] nums, int lo, int hi, int num) {
        if (lo > hi) {
            return -1;
        }
        if (lo == hi) {
            return nums[lo] == num ? lo : -1;
        }

        int mid = (lo+hi)/2;
        if (nums[mid] == num) {
            return mid;
        } else if (nums[mid] > num) {
            return search(nums, lo, mid-1, num);
        } else {
            return search(nums, mid+1, hi, num);
        }
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int h = hi;
        int val = nums[lo];
        int i = lo+1;
        while (i <= hi) {
            while (i <= hi && nums[i] <= val) {
                i++;
            }
            while (hi >= 0 && nums[hi] > val) {
                hi--;
            }
            if (i < hi) {
                exch(nums, i, hi);
            }
        }
        i--;
        if (lo < i) {
            exch(nums, lo, i);
        }
        sort(nums, lo, i-1);
        sort(nums, i+1, h);
    }

    private void exch(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
