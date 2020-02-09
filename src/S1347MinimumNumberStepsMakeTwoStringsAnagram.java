public class S1347MinimumNumberStepsMakeTwoStringsAnagram {
    public int minSteps(String s, String t) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            cnt[c-'a']--;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                res += cnt[i];
            }
        }
        return res;
    }
}
