public class S1573NumberWaysSplitString {
    public int numWays(String s) {
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }
        int MOD = (int)(Math.pow(10, 9) + 7);
        if (ones == 0) {
            int n = s.length();
            return (int)((long)((1.0*(n-1)*(n-2)/2))%MOD);
        }
        if (ones%3 != 0) {
            return 0;
        }
        ones = ones/3;
        int left = ones, right = ones;
        int i = 0, j = s.length()-1;
        while (left > 0) {
            char c = s.charAt(i);
            if (c == '1') {
                left--;
            }
            i++;
        }
        left++;
        while (s.charAt(i) != '1') {
            left++;
            i++;
        }
        while (right > 0) {
            char c = s.charAt(j);
            if (c == '1') {
                right--;
            }
            j--;
        }
        right++;
        while (s.charAt(j) != '1') {
            right++;
            j--;
        }
        return (int)(((long)left * right)%MOD);
    }
}
