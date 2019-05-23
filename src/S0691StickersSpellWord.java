import java.util.HashMap;

public class S0691StickersSpellWord {
    public int minStickers(String[] stickers, String target) {
        int[][] stick = new int[stickers.length][26];
        for (int i = 0; i < stick.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                stick[i][c-'a']++;
            }
        }
        HashMap<String, Integer> dp = new HashMap<>();
        dp.put("", 0);
        return min(stick, target, dp);
    }

    private int min(int[][] stickers, String target, HashMap<String, Integer> dp) {
        if (dp.containsKey(target)) {
            return dp.get(target);
        }

        int[] tar = new int[26];
        for (char c : target.toCharArray()) {
            tar[c-'a']++;
        }

        int res = -1;
        for (int i = 0; i < stickers.length; i++) {
            if (stickers[i][target.charAt(0)-'a'] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                for (int t = 0; t < tar[j]-stickers[i][j]; t++) {
                    sb.append((char)(j+'a'));
                }
            }
            int t = min(stickers, sb.toString(), dp);
            if (t != -1) {
                if (res == -1) {
                    res = 1+t;
                } else {
                    res = Math.min(res, 1+t);
                }
            }
        }
        dp.put(target, res);
        return res;
    }
}
