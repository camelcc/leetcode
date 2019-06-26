public class S0921MinimumAddMakeParenthesesValid {
    public int minAddToMakeValid(String S) {
        int res = 0;
        int leftCount = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                leftCount++;
            } else if (c == ')') {
                if (leftCount == 0) {
                    res++;
                } else {
                    leftCount--;
                }
            }
        }
        res += leftCount;
        return res;
    }
}
