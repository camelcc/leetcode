import java.util.HashSet;

public class S2135CountWordsObtainedAfterAddingLetter {
    public int wordCount(String[] startWords, String[] targetWords) {
        HashSet<Integer> possibles = new HashSet();
        for (String start : startWords) {
            int v = valueOf(start);
            for (int i = 0; i < 26; i++) {
                if ((v&(0x1<<i)) != 0) {
                    continue;
                }
                possibles.add(v|(0x1<<i));
            }
        }
        int res = 0;
        for (String target : targetWords) {
            int v = valueOf(target);
            if (possibles.contains(v)) {
                res++;
            }
        }
        return res;
    }

    private int valueOf(String word) {
        int res = 0;
        for (char c : word.toCharArray()) {
            res |= (0x1<<(c-'a'));
        }
        return res;
    }
}
