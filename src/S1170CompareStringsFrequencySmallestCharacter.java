import java.util.TreeMap;

public class S1170CompareStringsFrequencySmallestCharacter {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res = new int[queries.length];
        int[] freq = new int[11];
        for (String word : words) {
            char m = 'z'+1;
            int f = 0;
            for (char c : word.toCharArray()) {
                if (c == m) {
                    f++;
                } else if (c < m) {
                    m = c;
                    f = 1;
                }
            }
            freq[f]++;
        }
        int[] postSum = new int[12];
        postSum[10] = freq[10];
        for (int i = 9; i > 0; i--) {
            postSum[i] = postSum[i+1]+freq[i];
        }
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            char m = 'z'+1;
            int f = 0;
            for (char c : query.toCharArray()) {
                if (c == m) {
                    f++;
                } else if (c < m) {
                    m = c;
                    f = 1;
                }
            }
            res[i] = postSum[f+1];
        }
        return res;
    }
}
