public class S1003CheckIfWordIsValidAfterSubstitutions {
    public boolean isValid(String S) {
        String next = S.replace("abc", "");
        while (!next.equals(S)) {
            S = next;
            next = S.replace("abc", "");
        }
        return S.isEmpty();
    }
}
