// https://leetcode.com/problems/number-of-unique-good-subsequences/discuss/1431819/JavaC%2B%2BPython-DP-4-lines-O(N)-Time-O(1)-Space
public class S1987NumberUniqueGoodSubsequences {
    public int numberOfUniqueGoodSubsequences(String binary) {
        int MOD = 1_000_000_007;
        boolean zero = false;
        long end0 = 0, end1 = 0;
        for (char c : binary.toCharArray()) {
            if (c == '1') {
                end1 = (end0+end1+1)%MOD;
            } else {
                end0 = (end1+end0)%MOD;
                zero = true;
            }
        }
        long res = (end0+end1+(zero?1:0))%MOD;
        return (int)res;
    }
}
