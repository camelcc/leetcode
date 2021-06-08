// https://leetcode.com/problems/stone-game-viii/discuss/1241849/Java-2ms-O(N)-time-explanation
public class S1872StoneGameVIII {
    public int stoneGameVIII(int[] stones) {
        int[] sum = new int[stones.length+1];
        for (int i = 0; i < stones.length; i++) {
            sum[i+1] = sum[i]+stones[i];
        }

        Integer[] max = new Integer[stones.length];
        max[stones.length-1] = 0;
        max[stones.length-2] = sum[sum.length-1];
        for (int i = stones.length-3; i >= 0; i--) {
            max[i] = Math.max(sum[i+2]-max[i+1], max[i+1]);
        }
        return max[0];
    }
}
