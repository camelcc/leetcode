public class S1021RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {
        StringBuilder res = new StringBuilder();
        int left = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                left++;
                if (left != 1) {
                    assert left > 1;
                    res.append(c);
                }
            } else {
                assert c == ')';
                left--;
                if (left != 0) {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }
}
