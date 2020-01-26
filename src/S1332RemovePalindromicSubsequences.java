public class S1332RemovePalindromicSubsequences {
    public int removePalindromeSub(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();
        if (reverse.equals(s)) {
            return 1;
        }
        return 2;
    }
}
