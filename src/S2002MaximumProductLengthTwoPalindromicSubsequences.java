import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

public class S2002MaximumProductLengthTwoPalindromicSubsequences {
    public int maxProduct(String s) {
        List<int[]> palindrom = new ArrayList<>();
        for (int i = 1; i < (0x1<<s.length()); i++) {
            int l = palindrom(s, i);
            if (l > 0) {
                palindrom.add(new int[]{i, l});
            }
        }
        palindrom.sort(Comparator.comparingInt((ToIntFunction<int[]>) o -> o[1]).reversed());
        int res = 0;
        for (int i = 0; i < palindrom.size(); i++) {
            int vi = palindrom.get(i)[0], li = palindrom.get(i)[1];
            for (int j = i+1; j < palindrom.size(); j++) {
                int vj = palindrom.get(j)[0], lj = palindrom.get(j)[1];
                if (li*lj <= res) {
                    break;
                }
                if ((vi&vj) != 0) {
                    continue;
                }
                res = Math.max(res, li*lj);
            }
        }
        return res;
    }

    private int palindrom(String s, int v) {
        List<Character> sub = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if ((v & (0x1<<i)) != 0) {
                sub.add(s.charAt(i));
            }
        }
        int l = 0, r = sub.size()-1;
        while (l < r) {
            if (sub.get(l) == sub.get(r)) {
                l++;
                r--;
            } else {
                return -1;
            }
        }
        return sub.size();
    }
}
