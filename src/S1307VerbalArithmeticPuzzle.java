import java.util.*;

public class S1307VerbalArithmeticPuzzle {
    int[] digits = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public boolean isSolvable(String[] words, String result) {
        List<Character> unsolved = new ArrayList<>();
        HashMap<Integer, Integer> pos = new HashMap<>();
        int maxLen = 0;
        for (String word: words) {
            maxLen = Math.max(maxLen, word.length());
        }
        if (maxLen > result.length()) {
            return false;
        }
        maxLen = Math.max(maxLen, result.length());
        for (int p = 0; p < maxLen; p++) {
            for (String word: words) {
                if (word.length() > p) {
                    char c = word.charAt(word.length()-1-p);
                    if (!unsolved.contains(c)) {
                        unsolved.add(c);
                    }
                }
            }
            char c = result.charAt(result.length()-1-p);
            if (!unsolved.contains(c)) {
                unsolved.add(c);
            }
            pos.put(unsolved.size(), p);
        }
        char[] u = new char[unsolved.size()];
        for (int i = 0; i < unsolved.size(); i++) {
            u[i] = unsolved.get(i);
        }

        return solvable(words, result, new HashMap<>(), u, 0, pos);
    }

    private boolean solvable(String[] words, String result,
                             HashMap<Character, Integer> map,
                             char[] unsolved, int p,
                             HashMap<Integer, Integer> pos) {
        if (p == unsolved.length) {
            return solved(words, result, map);
        }

        for (int d : digits) {
            if (map.containsValue(d)) {
                continue;
            }
            map.put(unsolved[p], d);
            if (pos.containsKey(p+1)) {
                int dp = pos.get(p+1);
                int mod = (int)Math.pow(10, dp+1);
                int val = 0;
                for (String word : words) {
                    val += val(word, map, dp);
                }
                int tar = val(result, map, dp);
                if ((val-tar)%mod != 0) {
                    map.remove(unsolved[p]);
                    continue;
                }
            }

            if (solvable(words, result, map, unsolved, p+1, pos)) {
                return true;
            }
            map.remove(unsolved[p]);
        }
        return false;
    }

    private boolean solved(String[] words, String result, HashMap<Character, Integer> map) {
        int value = 0;
        for (String word : words) {
            value += val(word, map, word.length()-1);
        }
        return value == val(result, map, result.length()-1);
    }

    private int val(String word, HashMap<Character, Integer> map, int p) {
        int res = 0, base = 1;
        for (int t = 0; t <= Math.min(word.length()-1, p); t++) {
            char c = word.charAt(word.length()-1-t);
            res += base * map.get(c);
            base = base * 10;
        }
        return res;
    }
}
