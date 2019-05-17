public class S0514FreedomTrail {
    public int findRotateSteps(String ring, String key) {
        int[][] dp = new int[ring.length()][key.length()];
        return min(ring.toCharArray(), key.toCharArray(), 0, 0, dp);
    }

    private int min(char[] ring, char[] key, int ri, int ki, int[][] dp) {
        if (ki == key.length) {
            return 0;
        }
        if (dp[ri][ki] != 0) {
            return dp[ri][ki];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < ring.length; i++) {
            if (ring[(ri + i) % ring.length] == key[ki]) {
                res = Math.min(res, i+1+min(ring, key, (ri+i)%ring.length, ki+1, dp));
                break;
            }
        }
        for (int i = 0; i < ring.length; i++) {
            if (ring[(ring.length + ri - i) % ring.length] == key[ki]) {
                res = Math.min(res, i+1+min(ring, key, (ring.length+ri-i)%ring.length, ki+1, dp));
                break;
            }
        }
        dp[ri][ki] = res;
        return res;
    }
}
