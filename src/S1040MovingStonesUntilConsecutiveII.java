import java.util.Arrays;

public class S1040MovingStonesUntilConsecutiveII {
    public int[] numMovesStonesII(int[] stones) {
        int N = stones.length;
        Arrays.sort(stones);
        int maxLeft = stones[N-1]-stones[1]+1-N+1;
        int maxRight = stones[N-2]-stones[0]+1-N+1;
        int minLeft = 0, min = Integer.MAX_VALUE;
        for (int minRight = 0; minRight < N; minRight++) {
            while (stones[minRight]-stones[minLeft] >= N) {
                minLeft++;
            }
            if (minRight-minLeft+1 == N-1 && stones[minRight]-stones[minLeft] == N-2) {
                min = Math.min(min, 2);
            } else {
                min = Math.min(min, N-(minRight-minLeft+1));
            }
        }
        return new int[]{min, Math.max(maxLeft, maxRight)};
    }
}
