import java.util.HashSet;

public class S1805NumberDifferentIntegersString {
    public int numDifferentIntegers(String word) {
        StringBuilder sb = new StringBuilder();
        HashSet<String> res = new HashSet<>();
        for (char c : word.toCharArray()) {
            if (c >= '0' && c <= '9') {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    while (sb.length() > 1 && sb.charAt(0) == '0') {
                        sb.deleteCharAt(0);
                    }
                    res.add(sb.toString());
                }
                sb = new StringBuilder();
            }
        }
        if (sb.length() > 0) {
            while (sb.length() > 1 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
            res.add(sb.toString());
        }
        return res.size();
    }
}
