import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0068TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        List<String> current = new ArrayList<>();
        int len = 0;
        for (String word : words) {
            if (len + (len == 0 ? 0 : 1) + word.length() <= maxWidth) {
                current.add(word);
                len += (len == 0 ? 0 : 1) + word.length();
            } else {
                res.add(justify(current, len, current.size() == 1, maxWidth));
                current = new ArrayList<>();
                current.add(word);
                len = word.length();
            }
        }
        res.add(justify(current, len, true, maxWidth));
        return res;
    }

    private String justify(List<String> line, int len, boolean left, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        if (left) {
            for (int j = 0; j < line.size(); j++) {
                String word = line.get(j);
                sb.append(word);
                if (j != line.size()-1) {
                    sb.append(' ');
                }
            }
            while (sb.length() != maxWidth) {
                sb.append(' ');
            }
            return sb.toString();
        } else {
            int remains = maxWidth - len;
            int space = remains/(line.size()-1) + 1;
            char[] s = new char[space];
            Arrays.fill(s, ' ');
            remains = remains%(line.size()-1);
            for (int j = 0; j < line.size(); j++) {
                String word = line.get(j);
                sb.append(word);

                if (j != line.size()-1) {
                    sb.append(s);
                    if (remains > 0) {
                        sb.append(' ');
                        remains--;
                    }
                }
            }
            return sb.toString();
        }
    }
}
