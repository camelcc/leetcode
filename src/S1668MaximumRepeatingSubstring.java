public class S1668MaximumRepeatingSubstring {
    public int maxRepeating(String sequence, String word) {
        int lo = 0, hi = 1+sequence.length()/word.length();
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mid; i++) {
                sb.append(word);
            }
            String t = sb.toString();
            if (sequence.contains(t)) {
                if (lo == mid) {
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
