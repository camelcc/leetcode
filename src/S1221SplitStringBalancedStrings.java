public class S1221SplitStringBalancedStrings {
    public int balancedStringSplit(String s) {
        int cnt = 0, balance = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                balance--;
            } else if (c == 'R') {
                balance++;
            }
            if (balance == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
