public class S2116CheckParenthesesStringCanBeValid {
    public boolean canBeValid(String s, String locked) {
        if (s.length()%2 != 0) {
            return false;
        }
        int n = s.length();
        int possibleOpens = 0;
        int fixedCloses = 0;

        for (int i = 0; i < n; i ++) {
            if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
                possibleOpens++;
            } else {
                fixedCloses++;
            }

            if (fixedCloses > possibleOpens) return false;
        }

        int possibleCloses = 0;
        int fixedOpens = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || locked.charAt(i) == '0') {
                possibleCloses++;
            } else {
                fixedOpens++;
            }

            if (fixedOpens > possibleCloses) return false;
        }

        return true;
    }
}
