import java.util.HashMap;

public class S1079LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        HashMap<Character, Integer> cnt = new HashMap<>();
        for (char c : tiles.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0)+1);
        }
        int[] count = new int[cnt.size()];
        int p = 0;
        for (int c : cnt.values()) {
            count[p++] = c;
        }
        int res = 0;
        for (int len = 1; len <= tiles.length(); len++) {
            res += comb(count, len);
        }
        return res;
    }

    private int comb(int[] count, int len) {
        int res = 0;
        if (len == 1) {
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    res++;
                }
            }
            return res;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            count[i]--;
            res += comb(count, len-1);
            count[i]++;
        }
        return res;
    }
}
