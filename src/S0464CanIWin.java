import java.util.HashMap;

public class S0464CanIWin {
    private boolean[] used;
    private HashMap<Integer, Boolean> map;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if(sum < desiredTotal) return false;
        if(desiredTotal <= 0) return true;

        map = new HashMap<>();
        used = new boolean[maxChoosableInteger+1];
        return win(desiredTotal);
    }

    private boolean win(int total) {
        if (total <= 0) {
            return false;
        }
        int val = format(used);
        if (map.containsKey(val)) {
            return map.get(val);
        }
        for (int i = 1; i < used.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;

            if (!win(total - i)) {
                map.put(val, true);
                used[i] = false;
                return true;
            }

            used[i] = false;
        }
        map.put(val, false);
        return false;
    }

    public int format(boolean[] used){
        int num = 0;
        for(boolean b: used){
            num <<= 1;
            if(b) num |= 1;
        }
        return num;
    }
}
