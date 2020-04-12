import java.util.*;

public class S1408StringMatchingArray {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        boolean[] matched = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < i; j++) {
                if (matched[j]) {
                    continue;
                }
                if (word.contains(words[j])) {
                    matched[j] = true;
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (matched[i]) {
                res.add(words[i]);
            }
        }
        return res;
    }
}
