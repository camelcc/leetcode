import java.util.Arrays;

public class S0016_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                int first = nums[i];
                int second = nums[j];
                int third = near(nums, j+1, nums.length-1, target-first-second);
                if (Math.abs(sum-target) > Math.abs(first+second+third-target)) {
                    sum = first+second+third;
                }
            }
        }
        return sum;
    }

    private int near(int[] nums, int lo, int hi, int num) {
        int pos = search(nums, lo, hi, num);
        if (nums[pos] == num) {
            return num;
        } else if (pos == lo) {
            return nums[pos];
        } else {
            return nums[pos] - num < num - nums[pos-1] ? nums[pos] : nums[pos-1];
        }
    }

    private int search(int[] nums, int lo, int hi, int num) {
        if (lo > hi) {
            return -1;
        }
        if (lo == hi) {
            return lo;
        }
        int mid = (lo+hi)/2;
        if (nums[mid] == num) {
            return mid;
        } else if (nums[mid] > num) {
            return search(nums, lo, mid, num);
        } else {
            return search(nums, mid+1, hi, num);
        }
    }
}
