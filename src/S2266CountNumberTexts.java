import java.util.HashMap;

public class S2266CountNumberTexts {
    public int countTexts(String pressedKeys) {
        HashMap<Integer, Integer> threes = new HashMap<>();
        threes.put(1, 1);
        threes.put(2, 2);
        threes.put(3, 4);
        HashMap<Integer, Integer> fours = new HashMap<>();
        fours.put(1, 1);
        fours.put(2, 2);
        fours.put(3, 4);
        fours.put(4, 8);
        char prev = '\0';
        int len = 0;
        long res = 1;
        int MOD = 1_000_000_007;
        for (char c : pressedKeys.toCharArray()) {
            if (prev == c) {
                len++;
            } else {
                if (len > 0) {
                    res = (res * count(prev, len, threes, fours))%MOD;
                }
                prev = c;
                len = 1;
            }
        }
        if (len > 0) {
            res = (res * count(prev, len, threes, fours))%MOD;
        }
        return (int)res;
    }

    private int count(char digit, int len, HashMap<Integer, Integer> threes, HashMap<Integer, Integer> fours) {
        if (digit == '7' || digit == '9') {
            return count(false, len, fours);
        } else {
            return count(true, len, threes);
        }
    }

    private int count(boolean three, int len, HashMap<Integer, Integer> dp) {
        if (dp.containsKey(len)) {
            return dp.get(len);
        }
        // len > 3
        int MOD = 1_000_000_007;
        long res = 0;
        res = (res + count(three, len-1, dp))%MOD;
        res = (res + count(three, len-2, dp))%MOD;
        res = (res + count(three, len-3, dp))%MOD;
        if (!three) {
            res = (res + count(three, len-4, dp))%MOD;
        }
        dp.put(len, (int)res);
        return (int)res;
    }
}
