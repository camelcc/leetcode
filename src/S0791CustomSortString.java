import java.util.Arrays;

public class S0791CustomSortString {
    public String customSortString(String S, String T) {
        int[] sorted = new int[26];
        Arrays.fill(sorted, -1);
        int i = 0;
        while (i < S.length()) {
            sorted[S.charAt(i)-'a'] = i;
            i++;
        }
        for (int j = 0; j < 26; j++) {
            if (sorted[j] == -1) {
                sorted[j] = i;
                i++;
            }
        }

        char[] t = T.toCharArray();
        quickSort(t, 0, t.length-1, sorted);
        return new String(t);
    }

    private void quickSort(char[] chars, int start, int end, int[] sorted) {
        if (start >= end) {
            return;
        }

        int v = sorted[chars[start]-'a'];
        int i = start, j = end+1;
        while (true) {
            while (sorted[chars[++i]-'a'] < v) {
                if (i == end) {
                    break;
                }
            }
            while (sorted[chars[--j]-'a'] >= v) {
                if (j == start) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }

            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
        }
        char t = chars[j];
        chars[j] = chars[start];
        chars[start] = t;

        quickSort(chars, start, j-1, sorted);
        quickSort(chars, j+1, end, sorted);
    }
}
