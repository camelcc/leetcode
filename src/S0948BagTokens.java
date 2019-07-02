import java.util.Arrays;

public class S0948BagTokens {
    public int bagOfTokensScore(int[] tokens, int P) {
        if (tokens.length == 0) {
            return 0;
        }

        Arrays.sort(tokens);
        return max(tokens, 0, tokens.length-1, P, 0);
    }

    private int max(int[] tokens, int l, int r, int p, int s) {
        if (l == r) {
            return s + (p >= tokens[l] ? 1 : 0);
        }

        while (l <= r && tokens[l] <= p) {
            p -= tokens[l];
            l++;
            s++;
        }
        if (l > r || s == 0) {
            return s;
        }
        int res = s;
        s--;
        p += tokens[r];
        r--;
        res = Math.max(res, max(tokens, l, r, p, s));
        return res;
    }
}
