import java.util.Arrays;

public class S1156SwapForLongestRepeatedCharacterSubstring {
    public int maxRepOpt1(String text) {
        char[] tc = text.toCharArray();
        int res = 1;
        int prev = 1;

        int[] firstIndex = new int[26];
        int[] lastIndex = new int[26];
        Arrays.fill(firstIndex, -1);
        Arrays.fill(lastIndex, -1);
        firstIndex[tc[0]-'a'] = 0;
        for (int i = tc.length-1; i >= 0; i--) {
            if (lastIndex[tc[i]-'a'] == -1) {
                lastIndex[tc[i]-'a'] = i;
            }
        }

        for (int i = 1; i < tc.length; i++) {
            char c = tc[i];
            if (c == tc[i-1] && i != lastIndex[c-'a']) {
                prev++;
            } else if (c == tc[i-1] && i == lastIndex[c-'a']) {
                int j = i-1;
                boolean gap = false;
                while (j >= 0 && (tc[j] == c || !gap)) {
                    if (tc[j] != c) {
                        gap = true;
                    }
                    j--;
                }
                if (!gap) {
                    prev = i-j;
                } else {
                    if (j >= 0 && firstIndex[c-'a'] >= 0 && firstIndex[c-'a'] <= j) {
                        prev = i-j;
                    } else {
                        prev = i-j-1;
                    }
                }

            } else {
                int j = i-2;
                while (j >= 0 && tc[j] == c) {
                    j--;
                }
                if ((firstIndex[c-'a'] >= 0 && firstIndex[c-'a'] <= j) || lastIndex[c-'a'] > i) {
                    prev = i-j;
                } else {
                    prev = i-j-1;
                }

                if (firstIndex[c - 'a'] == -1) {
                    firstIndex[c - 'a'] = i;
                }
            }
            res = Math.max(res, prev);
        }
        return res;
    }
}
