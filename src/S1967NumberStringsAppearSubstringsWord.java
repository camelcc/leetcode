import java.util.HashSet;

public class S1967NumberStringsAppearSubstringsWord {
    public int numOfStrings(String[] patterns, String word) {
        HashSet<String> subs = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                subs.add(word.substring(i, j+1));
            }
        }
        int res = 0;
        for (String p : patterns) {
            if (subs.contains(p)) {
                res++;
            }
        }
        return res;
    }
}
