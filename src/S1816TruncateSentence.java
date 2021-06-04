import java.util.Arrays;

public class S1816TruncateSentence {
    public String truncateSentence(String s, int k) {
        String[] words = s.split(" ");
        String[] res = Arrays.copyOf(words, k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]);
            if (i != res.length-1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
