import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0018_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            List<List<Integer>> matches = threeSum(nums, i+1, target-nums[i], nums[i]);
            res.addAll(matches);
            while (i < nums.length-3 && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return res;
    }

    private List<List<Integer>> threeSum(int[] nums, int lo, int target, int candidate) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }

        for (int i = lo; i < nums.length-2; i++) {
            int first = nums[i];
            for (int j = i+1; j < nums.length-1; j++) {
                int second = nums[j];
                int pos = search(nums, j+1, nums.length-1, target-first-second);
                if (pos != -1) {
                    List<Integer> match = new ArrayList<>();
                    match.add(candidate);
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
}
