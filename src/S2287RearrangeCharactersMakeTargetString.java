public class S2287RearrangeCharactersMakeTargetString {
    public int rearrangeCharacters(String s, String target) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c-'a']++;
        }
        int[] tcnt = new int[26];
        for (char c : target.toCharArray()) {
            tcnt[c-'a']++;
        }

        int res = s.length();
        for (int i = 0; i < 26; i++) {
            if (tcnt[i] == 0) {
                continue;
            }
            res = Math.min(res, cnt[i]/tcnt[i]);
        }
        return res;
    }
}
