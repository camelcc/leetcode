// https://leetcode.com/problems/minimum-time-to-remove-all-cars-containing-illegal-goods/discuss/1748704/JavaC%2B%2BPython-Short-One-Pass-O(1)-Space
public class S2167MinimumTimeRemoveAllCarsContainingIllegalGoods {
    public int minimumTime(String s) {
        // cut [0, start)
        int left = 0, res = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                left = Math.min(i+1, left+2);
            }
            res = Math.min(res, left+s.length()-1-i);
        }
        return res;
    }
}
