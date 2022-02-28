public class S2186MinimumNumberStepsMakeTwoStringsAnagramII {
    public int minSteps(String s, String t) {
        int res = 0;
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            cnt[c-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            res += cnt[i] >= 0 ? cnt[i] : -cnt[i];
        }
        return res;
    }
}
