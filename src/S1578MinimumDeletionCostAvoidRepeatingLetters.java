public class S1578MinimumDeletionCostAvoidRepeatingLetters {
    public int minCost(String s, int[] cost) {
        int res = 0;
        int i = 0;
        while (i < s.length()) {
            if (i == s.length()-1) {
                break;
            }
            if (s.charAt(i) != s.charAt(i+1)) {
                i++;
                continue;
            }
            int j = i;
            int total = 0, max = 0;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                total += cost[j];
                max = Math.max(max, cost[j]);
                j++;
            }
            res += total-max;
            i = j;
        }
        return res;
    }
}
