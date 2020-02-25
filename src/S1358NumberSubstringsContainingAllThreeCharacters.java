public class S1358NumberSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        int res = 0;
        int[][] cnt = new int[s.length()+1][3];
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x == 'a') {
                a++;
            } else if (x == 'b') {
                b++;
            } else if (x == 'c') {
                c++;
            }
            cnt[i+1] = new int[]{a, b, c};
            if (a < 1 || b < 1 || c < 1) {
                continue;
            }

            int lo = 0, hi = i+1;
            while (lo <= hi) {
                int mid = lo + (hi-lo)/2;
                if (cnt[mid][0] < a && cnt[mid][1] < b && cnt[mid][2] < c) {
                    if (lo == mid) {
                        break;
                    }
                    lo = mid;
                } else {
                    hi = mid;
                }
            }

            res += lo+1;
        }

        return res;
    }
}
