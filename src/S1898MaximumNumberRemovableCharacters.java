import java.util.Arrays;

public class S1898MaximumNumberRemovableCharacters {
    public int maximumRemovals(String s, String p, int[] removable) {
        int lo = 0, hi = Math.min(removable.length+1, s.length()-p.length()+1);
        while (lo < hi) {
            // [0, mid)
            int mid = lo + (hi-lo)/2;
            int[] remove = Arrays.copyOf(removable, mid);
            Arrays.sort(remove);
            int si = 0, pi = 0, ri = 0;
            while (si < s.length()) {
                if (ri < remove.length && si == remove[ri]) {
                    ri++;
                } else {
                    if (s.charAt(si) == p.charAt(pi)) {
                        pi++;
                        if (pi == p.length()) {
                            break;
                        }
                    }
                }
                si++;
            }
            if (pi == p.length()) {
                if (mid == lo) {
                    break;
                }
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
