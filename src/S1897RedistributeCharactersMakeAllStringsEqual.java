public class S1897RedistributeCharactersMakeAllStringsEqual {
    public boolean makeEqual(String[] words) {
        int[] cnt = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                cnt[c-'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i]%words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
