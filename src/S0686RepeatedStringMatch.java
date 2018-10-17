public class S0686RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        if (A.length() >= B.length()) {
            if (A.contains(B)) {
                return 1;
            } else if (A.concat(A).contains(B)) {
                return 2;
            } else {
                return -1;
            }
        }

        // A.len < B.len
        int cnt = (int)Math.ceil(B.length()*1.0/A.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            sb.append(A);
        }
        A = sb.toString();
        if (A.contains(B)) {
            return cnt;
        } else if (A.concat(A).contains(B)) {
            return cnt+1;
        } else {
            return -1;
        }
    }
}
