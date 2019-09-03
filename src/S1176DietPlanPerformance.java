public class S1176DietPlanPerformance {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int sum = 0, current = 0;
        while (current < k-1) {
            sum += calories[current];
            current++;
        }
        int res = 0;
        for (; current < calories.length; current++) {
            sum += calories[current];
            if (current-k >= 0) {
                sum -= calories[current-k];
            }
            if (sum < lower) {
                res--;
            } else if (sum > upper) {
                res++;
            }
        }
        return res;
    }
}
