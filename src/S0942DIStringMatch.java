public class S0942DIStringMatch {
    public int[] diStringMatch(String S) {
        int min = 0, max = S.length();
        int[] res = new int[S.length()+1];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                res[i] = min++;
            } else { // D
                res[i] = max--;
            }
        }
        res[S.length()] = (S.charAt(S.length()-1) == 'I' ? min : max);
        return res;
    }
}
