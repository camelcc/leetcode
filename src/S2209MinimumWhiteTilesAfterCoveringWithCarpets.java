public class S2209MinimumWhiteTilesAfterCoveringWithCarpets {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        Integer[][] dp = new Integer[floor.length()][numCarpets+1];
        int[] whites = new int[floor.length()+1];
        for (int i = floor.length()-1; i >= 0; i--) {
            whites[i] = whites[i+1];
            if (floor.charAt(i) == '1') {
                whites[i]++;
            }
            dp[i][0] = whites[i];
        }
        return tiles(floor, whites, carpetLen, 0, numCarpets, dp);
    }

    private int tiles(String floor, int[] whites, int len, int p, int carpets, Integer[][] dp) {
        if (p >= floor.length() || whites[p] == 0) {
            return 0;
        }
        if (dp[p][carpets] != null) {
            return dp[p][carpets];
        }
        if (len * carpets >= floor.length()-p) {
            dp[p][carpets] = 0;
            return 0;
        }
        if (floor.charAt(p) == '0') {
            dp[p][carpets] = tiles(floor, whites, len, p+1, carpets, dp);
            return dp[p][carpets];
        }
        if (whites[p]-whites[p+len] == len) {
            dp[p][carpets] = tiles(floor, whites, len, p+len, carpets-1, dp);
            return dp[p][carpets];
        }
        // carpets != 0
        if (carpets == 1) {
            int total = whites[p];
            int reduce = 0;
            for (int i = p; i <= floor.length()-len; i++) {
                reduce = Math.max(reduce, whites[i]-whites[i+len]);
            }
            total -= reduce;
            dp[p][carpets] = total;
            return total;
        }
        // carpets > 1
        int res = whites[p];
        for (int i = p; i <= floor.length()-len; i++) {
            int r = whites[p]-whites[i];
            r += tiles(floor, whites, len, i+len, carpets-1, dp);
            res = Math.min(res, r);
        }
        dp[p][carpets] = res;
        return res;
    }
}
