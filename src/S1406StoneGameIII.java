import java.util.HashMap;

public class S1406StoneGameIII {
    public String stoneGameIII(int[] stoneValue) {
        int N = stoneValue.length;
        int[] postSum = new int[N];
        postSum[N-1] = stoneValue[N-1];
        for (int i = N-2; i >= 0; i--) {
            postSum[i] = stoneValue[i] + postSum[i+1];
        }
        int total = postSum[0];
        int alice = max(stoneValue, postSum, 0, new HashMap<>());
        if (total-alice > alice) {
            return "Bob";
        } else if (total-alice == alice) {
            return "Tie";
        } else {
            return "Alice";
        }
    }

    private int max(int[] stone, int[] postSum, int start, HashMap<Integer, Integer> dp) {
        if (dp.containsKey(start)) {
            return dp.get(start);
        }

        int N = stone.length;
        // 1
        int one = stone[start];
        if (start+1 == N) {
            dp.put(start, one);
            return one;
        } else {
            int other = max(stone, postSum, start+1, dp);
            one += postSum[start+1]-other;
        }
        int res = one;

        // 2
        if (start+2 <= N) {
            int two = stone[start]+stone[start+1];
            if (start+2 == N) {
                res = Math.max(res, two);
                dp.put(start, res);
                return res;
            } else {
                int other = max(stone, postSum, start+2, dp);
                two += postSum[start+2]-other;
                res = Math.max(res, two);
            }
        }
        // 3
        if (start+3 <= N) {
            int three = stone[start]+stone[start+1]+stone[start+2];
            if (start+3 == N) {
                res = Math.max(res, three);
                dp.put(start, res);
                return res;
            } else {
                int other = max(stone, postSum, start+3, dp);
                three += postSum[start+3]-other;
                res = Math.max(res, three);
            }
        }
        dp.put(start, res);
        return res;
    }
}
