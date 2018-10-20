public class S0859BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        char da = '\0', db = '\0';
        int dcnt = 0;
        int[] cnt = new int[26];
        for (int i = 0; i < A.length(); i++) {
            char ca = A.charAt(i);
            cnt[ca-'a']++;
            char cb = B.charAt(i);

            if (ca != cb) {
                if (dcnt >= 2) {
                    return false;
                } else if (dcnt == 1) {
                    if (ca != db || cb != da) {
                        return false;
                    }
                } else {
                    da = ca;
                    db = cb;
                }
                dcnt++;
            }
        }
        if (dcnt == 2) {
            return true;
        }
        if (dcnt == 1) {
            return false;
        }
        // equals
        for (int i = 0; i < 26; i++) {
            if (cnt[i] >= 2) {
                return true;
            }
        }
        return false;
    }
}

