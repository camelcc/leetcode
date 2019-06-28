public class S0926FlipStringMonotoneIncreasing {
    public int minFlipsMonoIncr(String S) {
        char[] s = S.toCharArray();
        int ones = 0, flip = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '1') {
                ones++;
            } else {
                flip++;
            }
            flip = Math.min(ones, flip);
        }
        return flip;
    }
}
