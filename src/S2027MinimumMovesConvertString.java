public class S2027MinimumMovesConvertString {
    public int minimumMoves(String s) {
        int res = 0, cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == 'X') {
                if (cnt > 0) {
                    cnt--;
                } else {
                    cnt = 2;
                    res++;
                }
            } else {
                if (cnt > 0) {
                    cnt--;
                }
            }
        }
        return res;
    }
}
