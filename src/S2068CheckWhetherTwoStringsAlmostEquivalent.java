public class S2068CheckWhetherTwoStringsAlmostEquivalent {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] cnt = new int[26];
        for (char c : word1.toCharArray()) {
            cnt[c-'a']++;
        }
        for (char c : word2.toCharArray()) {
            cnt[c-'a']--;
        }
        for (int c : cnt) {
            if (c > 3 || c < -3) {
                return false;
            }
        }
        return true;
    }
}
