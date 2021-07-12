// https://leetcode.com/problems/sum-game/discuss/1331779/Proof-and-strategy
public class S1927SumGame {
    public boolean sumGame(String num) {
        int n = num.length();
        double res = 0;
        for (int i = 0; i < n; ++i)
            res += (i < n / 2 ? 1 : -1) * (num.charAt(i) == '?' ? 4.5 : num.charAt(i) - '0');
        return res != 0;
    }
}
