public class S1614MaximumNestingDepthParentheses {
    public int maxDepth(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int res = 0;
        int left = -1, right = -1, depth = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (left == -1) {
                    left = i;
                }
                depth--;
            } else if (c == ')') {
                right = i;
                depth++;
                if (depth == 0) {
                    if (left+1 == right) {
                        res = Math.max(res, 1);
                    } else {
                        res = Math.max(res, 1+maxDepth(s.substring(left+1, right)));
                    }
                    left = -1;
                    right = -1;
                }
            }
        }
        return res;
    }
}
