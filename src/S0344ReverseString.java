public class S0344ReverseString {
    public String reverseString(String s) {
        char[] r = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            r[s.length()-1-i] = s.charAt(i);
        }
        return String.valueOf(r);
    }
}
