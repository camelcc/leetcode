import java.util.Stack;

public class S1963MinimumNumberSwapsMakeStringBalanced {
    public int minSwaps(String s) {
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                left++;
            } else if (c == ']') {
                if (left > 0) {
                    left--;
                }
            }
        }
        return (int)Math.ceil(left*1.0/2);
    }
}
