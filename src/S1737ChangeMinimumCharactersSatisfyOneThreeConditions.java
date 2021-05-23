public class S1737ChangeMinimumCharactersSatisfyOneThreeConditions {
    public int minCharacters(String a, String b) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            char c = (char)('a'+i);
            if (c == 'a') {
                int e = 0;
                for (char ca : a.toCharArray()) {
                    if (ca != c) {
                        e++;
                    }
                }
                for (char cb : b.toCharArray()) {
                    if (cb != c) {
                        e++;
                    }
                }
                res = Math.min(res, e);
                continue;
            }

            int equal = 0, big = 0, small = 0;
            for (char ca : a.toCharArray()) {
                // a > b
                if (ca < c) {
                    big++;
                }
                // a < b
                if (ca >= c) {
                    small++;
                }
                // a = b
                if (ca != c) {
                    equal++;
                }
            }
            for (char cb : b.toCharArray()) {
                // a > b
                if (cb >= c) {
                    big++;
                }
                // a < b
                if (cb < c) {
                    small++;
                }
                // a = b
                if (cb != c) {
                    equal++;
                }
            }
            int t = 0;
            if (big != -1 && small != -1) {
                t = Math.min(equal, Math.min(big, small));
            } else {
                t = equal;
            }
            res = Math.min(res, t);
        }
        return res;
    }
}
