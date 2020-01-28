public class S1328BreakPalindrome {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() <= 1) {
            return "";
        }
        int i = 0;
        while (i < palindrome.length()/2) {
            if (palindrome.charAt(i) != 'a') {
                break;
            }
            i++;
        }
        char[] c = palindrome.toCharArray();
        if (i < palindrome.length()/2) {
            c[i] = 'a';
        } else {
            c[c.length-1] = 'b';
        }
        return new String(c);
    }
}
