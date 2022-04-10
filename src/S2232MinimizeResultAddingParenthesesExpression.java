public class S2232MinimizeResultAddingParenthesesExpression {
    public String minimizeResult(String expression) {
        int index = expression.indexOf('+');
        int value = Integer.MAX_VALUE;
        String res = expression;
        for (int left = 0; left < index; left++) {
            int l = left == 0 ? 1 : Integer.parseInt(expression.substring(0, left));
            String sl = left == 0 ? "" : expression.substring(0, left);
            for (int right = expression.length(); right > index+1; right--) {
                int ml = Integer.parseInt(expression.substring(left, index));
                int mr = Integer.parseInt(expression.substring(index+1, right));
                String sm = expression.substring(left, right);
                int r = right == expression.length() ? 1 : Integer.parseInt(expression.substring(right));
                String sr = right == expression.length() ? "" : expression.substring(right);
                int p = l * (ml + mr) * r;
                if (p < value) {
                    value = p;
                    res = sl + "(" + sm + ")" + sr;
                }
            }
        }
        return res;
    }
}
