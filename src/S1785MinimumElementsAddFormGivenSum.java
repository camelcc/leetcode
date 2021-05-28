public class S1785MinimumElementsAddFormGivenSum {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int n : nums) {
            sum += n;
        }
        long gap = Math.abs(sum-goal);
        return (int)Math.ceil(gap*1.0/limit);
    }
}
