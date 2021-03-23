import java.util.Arrays;
import java.util.HashMap;

public class S1601MaximumNumberAchievableTransferRequests {
    public int maximumRequests(int n, int[][] requests) {
        HashMap<String, Integer>[] dp = new HashMap[requests.length];
        for (int i = 0; i < requests.length; i++) {
            dp[i] = new HashMap<>();
        }
        return max(n, new int[n], requests, 0, dp);
    }

    private int max(int n, int[] v, int[][] request, int i, HashMap<String, Integer>[] dp) {
        String k = key(v);
        if (dp[i].containsKey(k)) {
            return dp[i].get(k);
        }

        // don't include i
        int res = -1;

        if (i == request.length-1) {
            if (balance(v)) {
                res = Math.max(res, 0);
            } else {
                res = Math.max(res, -1);
            }
        } else {
            int t = max(n, Arrays.copyOf(v, v.length), request, i+1, dp);
            if (t >= 0) {
                res = Math.max(res, t);
            } else {
                res = Math.max(res, -1);
            }
        }

        // include i
        v[request[i][0]]--;
        v[request[i][1]]++;
        if (i == request.length-1) {
            if (balance(v)) {
                res = Math.max(res, 1);
            } else {
                res = Math.max(res, -1);
            }
        } else {
            int t = max(n, v, request, i+1, dp);
            if (t >= 0) {
                res = Math.max(res, t+1);
            } else {
                res = Math.max(res, -1);
            }
        }
        dp[i].put(k, res);
        return res;
    }

    private boolean balance(int[] v) {
        for (int i : v) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    private String key(int[] v) {
        StringBuilder sb = new StringBuilder();
        for (int i : v) {
            sb.append(i).append(',');
        }
        return sb.toString();
    }
}
