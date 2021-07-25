public class S1941CheckAllCharactersHaveEqualNumberOccurrences {
    public boolean areOccurrencesEqual(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c-'a']++;
        }
        int c = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            if (c != 0 && c != cnt[i]) {
                return false;
            }
            c = cnt[i];
        }
        return true;
    }
}
