public class S0268MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (n+1)*n/2;
        int s = 0;
        for (int num : nums) {
            s += num;
        }
        return sum - s;
    }
}
