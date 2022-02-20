public class S2182ConstructStringWithRepeatLimit {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int i = 25;
        while (i >= 0) {
            if (cnt[i] == 0) {
                i--;
                continue;
            }
            char c = (char)('a'+i);

            if (cnt[i] <= repeatLimit) {
                for (int t = 0; t < cnt[i]; t++) {
                    sb.append(c);
                }
                cnt[i] = 0;
                i--;
                continue;
            }

            // cnt[i] > repeatLimit
            for (int t = 0; t < repeatLimit; t++) {
                sb.append(c);
            }
            cnt[i] -= repeatLimit;
            boolean find = false;
            for (int t = i-1; t >= 0; t--) {
                if (cnt[t] > 0) {
                    cnt[t]--;
                    sb.append((char)('a'+t));
                    find = true;
                    break;
                }
            }
            if (!find) {
                break;
            }
        }
        return sb.toString();
    }
}
