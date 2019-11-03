public class S1247MinimumSwapsMakeStringsEqual {
    public int minimumSwap(String s1, String s2) {
        int diffX = 0, diffY = 0;
        int res = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (c1 == c2) {
                continue;
            }
            if (c1 == 'x') {
                assert c2 == 'y';
                diffX++;
            } else if (c1 == 'y') {
                assert c2 == 'x';
                diffY++;
            }
        }
        res += diffX/2;
        diffX = diffX%2;
        res += diffY/2;
        diffY = diffY%2;
        if (diffX == 0 && diffY == 0) {
            return res;
        } else if (diffX == 1 && diffY == 1) {
            return res + 2;
        } else {
            return -1;
        }
    }
}
