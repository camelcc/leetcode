import java.util.Arrays;

public class S1930UniqueLength3PalindromicSubsequences {
    public int countPalindromicSubsequence(String s) {
        int[][] range = new int[2][26];
        Arrays.fill(range[0], Integer.MAX_VALUE);
        Arrays.fill(range[1], -1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            range[0][c-'a'] = Math.min(range[0][c-'a'], i);
            range[1][c-'a'] = Math.max(range[0][c-'a'], i);
        }

        boolean[][] exist = new boolean[26][26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < 26; j++) {
                if (range[0][j] < i && i < range[1][j]) {
                    exist[j][c-'a'] = true;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (exist[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }
}
