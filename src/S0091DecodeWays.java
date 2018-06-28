import java.util.ArrayList;
import java.util.List;

public class S0091DecodeWays {
    public int numDecodings(String s) {
        if (s.isEmpty()) {
            return 1;
        }
        int first = s.charAt(0) - '0';
        if (s.length() == 1) {
            return first == 0 ? 0 : 1;
        }

        List<String> segments = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            current.append(s.charAt(i));
            int c = s.charAt(i) - '0';
            if (c > 2) {
                segments.add(current.toString());
                current = new StringBuilder();
            }
        }
        if (current.length() > 0) {
            segments.add(current.toString());
        }

        int res = 1;
        for (int i = 0; i < segments.size(); i++) {
            res = res * decodings(segments.get(i));
        }
        return res;
    }

    private int decodings(String s) {
        if (s.isEmpty()) {
            return 1;
        }
        int first = s.charAt(0) - '0';
        if (s.length() == 1) {
            return first == 0 ? 0 : 1;
        }

        int second = s.charAt(1) - '0';
        if (first > 2) {
            return numDecodings(s.substring(1));
        } else if (first == 2) {
            if (second >= 1 && second <= 6) {
                return numDecodings(s.substring(1)) + numDecodings(s.substring(2));
            } else {
                return numDecodings(s.substring(2));
            }
        } else if (first == 1) { // 1
            if (second == 0) {
                return numDecodings(s.substring(2));
            } else {
                return numDecodings(s.substring(1)) + numDecodings(s.substring(2));
            }
        } else {
            return 0;
        }
    }
}
