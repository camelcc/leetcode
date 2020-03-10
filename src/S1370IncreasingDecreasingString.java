public class S1370IncreasingDecreasingString {
    public String sortString(String s) {
        int len = s.length();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c-'a']++;
        }
        boolean increase = false;
        StringBuilder sb = new StringBuilder();
        while (len > 0) {
            increase = !increase;
            if (increase) {
                for (int i = 0; i < 26; i++) {
                    if (cnt[i] > 0) {
                        sb.append((char)('a'+i));
                        cnt[i]--;
                        len--;
                    }
                }
            } else {
                for (int i = 25; i >= 0; i--) {
                    if (cnt[i] > 0) {
                        sb.append((char)('a'+i));
                        cnt[i]--;
                        len--;
                    }
                }
            }
        }
        return sb.toString();
    }
}
