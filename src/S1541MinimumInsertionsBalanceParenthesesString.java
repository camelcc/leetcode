import java.util.Stack;

public class S1541MinimumInsertionsBalanceParenthesesString {
    public int minInsertions(String s) {
        int left = 0, right = 0, res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (right == 1) {
                    if (left == 0) {
                        res += 2;
                    } else {
                        res++;
                        left--;
                    }
                    right = 0;
                }
                left++;
            } else if (c == ')') {
                if (left == 0) {
                    res++;
                    left++;
                }

                if (right == 1) {
                    right = 0;
                    if (left > 0) {
                        left--;
                    } else {
                        res++;
                    }
                } else {
                    right = 1;
                }
            }
        }
        if (right == 1) {
            if (left == 0) {
                res += 2;
            } else {
                res++;
                left--;
            }
        }
        res += left*2;
        return res;
    }
}
