public class S0767ReorganizeString {
    public String reorganizeString(String S) {
        int[] cnt = new int[26];
        int pos = 0;
        for (char c : S.toCharArray()) {
            cnt[c-'a']++;
            if (cnt[c-'a'] > cnt[pos]) {
                pos = c-'a';
            }
        }

        int len = S.length();
        StringBuilder[] sbs = new StringBuilder[cnt[pos]];
        for (int t = 0; t < cnt[pos]; t++) {
            sbs[t] = new StringBuilder();
        }
        for (StringBuilder sb : sbs) {
            sb.append((char)('a'+pos));
            len--;
        }
        cnt[pos] = 0;
        int i = 0;
        int j = 0;
        while (len > 0) {
            if (cnt[j] == 0) {
                j++;
                continue;
            }

            sbs[i].append((char)('a'+j));
            if (i == sbs.length-1) {
                i = 0;
            } else {
                i++;
            }
            cnt[j]--;
            len--;
        }

        if (sbs[i].length() == 1 && i < sbs.length-1 && sbs[i+1].length() == 1) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : sbs) {
            res.append(sb.toString());
        }
        return res.toString();
    }
}
