public class S1529BulbSwitcherIV {
    public int minFlips(String target) {
        int res = 0;
        boolean cur = false;
        for (char c : target.toCharArray()) {
            if (c == '0') {
                if (cur) {
                    res++;
                    cur = false;
                }
            } else if (c == '1') {
                if (!cur) {
                    res++;
                    cur = true;
                }
            }
        }
        return res;
    }
}
