import java.util.Arrays;

public class S0820ShortEncodingWords {
    public int minimumLengthEncoding(String[] words) {
        for (int i = 0; i < words.length; i++) {
            char[] rev = new char[words[i].length()];
            int j = rev.length-1;
            for (char c : words[i].toCharArray()) {
                rev[j--] = c;
            }
            words[i] = new String(rev);
        }
        Arrays.sort(words);

        int res = words[words.length-1].length()+1;
        for (int i = 0; i < words.length-1; i++) {
            if (!words[i+1].startsWith(words[i])) {
                res += words[i].length()+1;
            }
        }
        return res;
    }
}
