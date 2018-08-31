import java.util.HashSet;

//TODO: DP solution
public class S0467UniqueSubstrings {
    public int findSubstringInWraproundString(String p) {
        if (p.isEmpty()) {
            return 0;
        }

        HashSet<String> segments = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        sb.append(p.charAt(0));
        for (int i = 1; i < p.length(); i++) {
            char last = sb.charAt(sb.length() - 1);
            char current = p.charAt(i);
            if (last == 'z' && current == 'a' || current - last == 1) {
                sb.append(current);
            } else {
                String seg = sb.toString();
                String match = null;
                for (String s : segments) {
                    if (s.contains(seg) || seg.contains(s)) {
                        match = s;
                        break;
                    }
                }

                if (match != null) {
                    assert !match.isEmpty();
                    if (seg.contains(match)) {
                        segments.remove(match);
                        segments.add(seg);
                    }
                } else {
                    segments.add(sb.toString());
                }
                sb = new StringBuilder();
                sb.append(current);
            }
        }
        if (sb.length() > 0) {
            segments.add(sb.toString());
        }

        int cnt = 0;
        for (String s : segments) {
            cnt += (1 + s.length()) * s.length() / 2;
        }
        return cnt;
    }
}
