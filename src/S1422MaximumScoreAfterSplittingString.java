public class S1422MaximumScoreAfterSplittingString {
    public int maxScore(String s) {
        int zeros = 0, ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }
        int res = 0;
        for (int i = 0; i < s.length()-1; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                zeros++;
            } else if (c == '1') {
                ones--;
            }
            res = Math.max(res, zeros+ones);
        }
        return res;
    }
}
