import java.util.ArrayList;
import java.util.List;

public class S0809ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        if (S.length() == 0) {
            for (String word : words) {
                if (word.length() == 0) {
                    res++;
                }
            }
            return res;
        }

        List<String> sgroup = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char last = S.charAt(0);
        sb.append(last);
        for (int i = 1; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c != last) {
                sgroup.add(sb.toString());
                sb = new StringBuilder();
            }

            sb.append(c);
            last = c;
        }
        sgroup.add(sb.toString());

        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            sb = new StringBuilder();
            boolean valid = true;
            last = word.charAt(0);
            sb.append(last);
            int index = 0;
            for (int i = 1; i < word.length() && index < sgroup.size(); i++) {
                char c = word.charAt(i);
                if (c != last) {
                    String src = sgroup.get(index);
                    String dst = sb.toString();
                    if (comp(src, dst)) {
                        index++;
                    } else {
                        valid = false;
                        break;
                    }
                    sb = new StringBuilder();
                }

                sb.append(c);
                last = c;
            }

            if (index != sgroup.size()-1 || !valid) {
                continue;
            }
            if (comp(sgroup.get(index), sb.toString())) {
                res++;
            }
        }

        return res;
    }

    private boolean comp(String src, String dst) {
        if (src.length() < 3 || dst.length() >= src.length()) {
            return dst.equals(src);
        } else {
            return src.charAt(0) == dst.charAt(0);
        }
    }
}
