public class S0796RotateString {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.isEmpty()) {
            return true;
        }
        return (A+A).contains(B);
    }
}
