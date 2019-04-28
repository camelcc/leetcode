import java.util.Arrays;

public class S0087ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() == 1) {
            return s1.equals(s2);
        }
        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars2);
        if (!String.valueOf(chars1).equals(String.valueOf(chars2))) {
            return false;
        }

        for (int i = 1; i < s1.length(); i++) {
            String left1 = s1.substring(0, i);
            String right1 = s1.substring(i);
            if ((isScramble(left1, s2.substring(0, i)) && isScramble(right1, s2.substring(i))) ||
                (isScramble(right1, s2.substring(0, s2.length()-i)) && isScramble(left1, s2.substring(s2.length()-i)))) {
                return true;
            }
        }
        return false;
    }
}
