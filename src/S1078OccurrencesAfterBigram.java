import java.util.ArrayList;
import java.util.List;

public class S1078OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> anwser = new ArrayList<>();
        String pattern = first + " " + second + " ";
        int p = 0;
        while (p < text.length()) {
            int i = text.indexOf(pattern, p);
            if (i == -1) {
                break;
            }
            int b = i+pattern.length();
            StringBuilder sb = new StringBuilder();
            while (b < text.length() && text.charAt(b) != ' ') {
                sb.append(text.charAt(b));
                b++;
            }
            anwser.add(sb.toString());
            p = i + first.length();
        }
        String[] res = new String[anwser.size()];
        for (int i = 0; i < anwser.size(); i++) {
            res[i] = anwser.get(i);
        }
        return res;
    }
}
