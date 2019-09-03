import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class S1178NumberValidWordsEachPuzzle {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        int[] wv = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int v = 0;
            for (char pc : words[i].toCharArray()) {
                v |= (0x1 << (pc-'a'));
            }
            wv[i] = v;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < puzzles.length; i++) {
            int v = 0, first = 0x1 << (puzzles[i].charAt(0)-'a');
            for (char c : puzzles[i].toCharArray()) {
                v |= (0x1 << (c-'a'));
            }
            int cnt = 0;
            for (int w : wv) {
                if ((w&v) == w && (w&first) == first) {
                    cnt++;
                }
            }
            res.add(cnt);
        }
        return res;
    }
}
