import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S0722RemoveComments {
    public List<String> removeComments(String[] source) {
        List<String> codes = new ArrayList<>();
        Collections.addAll(codes, source);

        boolean inComment = false;
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (!codes.isEmpty()) {
            String s = codes.remove(0);
            if (s.isEmpty()) {
                continue;
            }

            if (inComment) {
                int i = s.indexOf("*/");
                if (i != -1) {
                    inComment = false;
                    sb.append(s, i+2, s.length());
                    String t = sb.toString();
                    if (!t.isEmpty()) {
                        codes.add(0, t);
                        sb = new StringBuilder();
                    }
                }
            } else {
                int b1 = s.indexOf("//");
                int begin = s.indexOf("/*");
                if (b1 == -1 && begin == -1) {
                    res.add(s);
                    continue;
                }
                if (b1 != -1 && (begin == -1 || b1 < begin)) {
                    String t = s.substring(0, b1);
                    if (!t.isEmpty()) {
                        res.add(t);
                    }
                    continue;
                }
                // b1 > begin || b1 == -1
                sb.append(s, 0, begin);
                int end = s.indexOf("*/", begin+2);
                if (end != -1) {
                    sb.append(s, end + 2, s.length());
                    if (sb.length() != 0) {
                        codes.add(0, sb.toString());
                        sb = new StringBuilder();
                    }
                    continue;
                }

                // start but not end
                inComment = true;
            }
        }
        return res;
    }
}
