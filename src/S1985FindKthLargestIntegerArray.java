import java.util.Arrays;

public class S1985FindKthLargestIntegerArray {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            return o1.compareTo(o2);
        });
        return nums[nums.length-k];
    }
}
