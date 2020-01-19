import java.util.ArrayList;
import java.util.List;

public class S1324PrintWordsVertically {
    public List<String> printVertically(String s) {
        String[] words = s.trim().split(" ");
        int len = 0;
        for (String w : words) {
            len = Math.max(len, w.length());
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            for (int r = 0; r < words.length; r++) {
                if (i < words[r].length()) {
                    sb.append(words[r].charAt(i));
                } else {
                    sb.append(' ');
                }
            }
            String t = sb.toString();
            String d = t.trim();
            char c = d.charAt(d.length()-1);
            int l = t.lastIndexOf(c)+1;
            res.add(t.substring(0, l));
        }
        return res;
    }
}
