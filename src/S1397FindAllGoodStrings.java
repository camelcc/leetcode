import java.util.Arrays;

public class S1397FindAllGoodStrings {
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        int[] memo = new int[1 << 17]; // Need total 17 bits, can check getKey() function
        Arrays.fill(memo, -1);
        return dfs(0, 0, true, true,
                n, s1.toCharArray(), s2.toCharArray(), evil.toCharArray(), computeLPS(evil.toCharArray()), memo);
    }
    int dfs(int i, int evilMatched, boolean leftBound, boolean rightBound,
            int n, char[] s1, char[] s2, char[] evil, int[] lps, int[] memo) {
        if (evilMatched == evil.length) return 0; // contain `evil` as a substring -> not good string
        if (i == n) return 1; // it's a good string
        int key = getKey(i, evilMatched, leftBound, rightBound);
        if (memo[key] != -1) return memo[key];
        char from = leftBound ? s1[i] : 'a';
        char to = rightBound ? s2[i] : 'z';
        int res = 0;
        for (char c = from; c <= to; c++) {
            int j = evilMatched; // j means the next match between current string (end at char `c`) and `evil` string
            while (j > 0 && evil[j] != c) j = lps[j - 1];
            if (c == evil[j]) j++;
            res += dfs(i + 1, j, leftBound && (c == from), rightBound && (c == to),
                    n, s1, s2, evil, lps, memo);
            res %= 1000000007;
        }
        return memo[key] = res;
    }
    int getKey(int n, int m, boolean b1, boolean b2) {
        // Need 9 bits store n (2^9=512), 6 bits store m (2^6=64), 1 bit store b1, 1 bit store b2
        return (n << 8) | (m << 2) | ((b1 ? 1 : 0) << 1) | (b2 ? 1 : 0);
    }
    int[] computeLPS(char[] str) { // Longest Prefix also Suffix
        int n = str.length;
        int[] lps = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && str[i] != str[j]) j = lps[j - 1];
            if (str[i] == str[j]) lps[i] = ++j;
        }
        return lps;
    }
}
