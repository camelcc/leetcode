import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S1585CheckStringTransformableWithSubstringSortOperations {
    public boolean isTransformable(String s, String t) {
        for (char c = '0'; c <= '9'; c++) {
            List<Integer> si = new ArrayList<>();
            List<Integer> ti = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    si.add(i);
                }
                if (t.charAt(i) == c) {
                    ti.add(i);
                }
            }
            if (si.size() != ti.size()) {
                return false;
            }
            for (int j = 0; j < si.size(); j++) {
                if (si.get(j) < ti.get(j)) {
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder tb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != c) {
                    sb.append(s.charAt(i));
                }
                if (t.charAt(i) != c) {
                    tb.append(t.charAt(i));
                }
            }
            s = sb.toString();
            t = tb.toString();
        }
        return true;
    }
}
