import java.util.Arrays;

public class S2262TotalAppealAString {
    public long appealSum(String s) {
        long res = 1;
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        lastSeen[s.charAt(0)-'a'] = 0;
        long prev = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            long current = 0;
            if (lastSeen[c-'a'] == -1) {
                current += prev + (i+1);
            } else {
                current += prev + (i-lastSeen[c-'a']);
            }
            lastSeen[c-'a'] = i;
            res += current;
            prev = current;
        }
        return res;
    }
}
