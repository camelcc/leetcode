import java.util.Arrays;
import java.util.Comparator;

public class S1859SortingSentence {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        Arrays.sort(words, Comparator.comparingInt(o -> o.charAt(o.length()-1)-'0'));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i], 0, words[i].length()-1);
            if (i != words.length-1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
