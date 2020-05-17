import java.util.Arrays;
import java.util.Comparator;

public class S1451RearrangeWordsSentence {
    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        if (words.length <= 1) {
            return text;
        }
        words[0] = words[0].toLowerCase();
        Integer[] index = new Integer[words.length];
        for (int i = 0; i < words.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (Integer i1, Integer i2) -> {
            if (words[i1].length() != words[i2].length()) {
                return words[i1].length() - words[i2].length();
            }
            return i1-i2;
        });
        String first = words[index[0]];
        words[index[0]] = first.substring(0, 1).toUpperCase() + first.substring(1);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            res.append(words[index[i]]);
            if (i != words.length-1) {
                res.append(" ");
            }
        }
        return res.toString();
    }
}
