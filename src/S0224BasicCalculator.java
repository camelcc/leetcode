import java.util.Stack;

public class S0224BasicCalculator {
    public int calculate(String s) {
        int current = 0;
        int sign = 1;
        Stack<Integer> vals = new Stack<>();
        Stack<Integer> signs = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ' ') {
            } else if (c == '-') {
                sign = -1;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '(') {
                vals.push(current);
                signs.push(sign);
                current = 0;
                sign = 1;
            } else if (c == ')') {
                int t = vals.pop();
                sign = signs.pop();
                current = t + sign*current;
            } else {
                assert c >= '0' && c <= '9';
                StringBuilder val = new StringBuilder();
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    val.append(s.charAt(j));
                    j++;
                }
                current += sign*Integer.valueOf(val.toString());
                i = j-1;
                sign = 1;
            }
            i++;
        }
        return current;
    }
}
