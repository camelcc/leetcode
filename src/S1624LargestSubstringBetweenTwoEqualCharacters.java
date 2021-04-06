import java.util.Arrays;

public class S1624LargestSubstringBetweenTwoEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        int res = -1;
        int[] loc = new int[26];
        Arrays.fill(loc, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (loc[c-'a'] == -1) {
                loc[c-'a'] = i;
            } else {
                res = Math.max(res, i-1-loc[c-'a']);
            }
        }
        return res;
    }
}
