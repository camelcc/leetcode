// https://leetcode.com/problems/substring-with-largest-variance/discuss/2038883/Kotlin-or-Kadane-or-26*26*N
public class S2272SubstringWithLargestVariance {
    public int largestVariance(String s) {
        char[] ch = s.toCharArray();
        boolean[] exist = new boolean[26];
        for (int i = 0; i < ch.length; i++) {
            exist[ch[i]-'a'] = true;
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j || !exist[i] || !exist[j]) {
                    continue;
                }
                int r = kadane(ch, (char)('a'+i), (char)('a'+j));
                res = Math.max(res, r);
            }
        }
        return res;
    }

    private int kadane(char[] ch, int a, int b) {
        boolean negative = false;
        int sum = 0, max = 0;
        for (char c : ch) {
            if (c == a) {
                sum++;
            } else if (c == b) {
                sum--;
            }
            if (c == b) {
                negative = true;
            }
            if (negative) {
                max = Math.max(max, sum);
            } else {
                max = Math.max(max, sum-1);
            }
            if (sum < 0) {
                sum = 0;
                negative = false;
            }
        }
        return max;
    }
}
