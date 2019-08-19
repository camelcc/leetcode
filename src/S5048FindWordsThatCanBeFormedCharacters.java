import java.util.Arrays;

public class S5048FindWordsThatCanBeFormedCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] cnt = new int[26];
        for (char c : chars.toCharArray()) {
            cnt[c-'a']++;
        }
        int res = 0;
        for (String word : words) {
            int[] c = Arrays.copyOf(cnt, cnt.length);
            boolean good = true;
            for (char w : word.toCharArray()) {
                if (c[w-'a'] <= 0) {
                    good = false;
                    break;
                }
                c[w-'a']--;
            }
            if (good) {
                res += word.length();
            }
        }
        return res;
    }
}
