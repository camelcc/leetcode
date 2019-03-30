public class S0848ShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        char[] res = S.toCharArray();
        int shift = 0;
        for (int i = shifts.length-1; i >= 0; i--) {
            shift = (shift + shifts[i])%26;
            // res[i] = res[i] >> shift;
            int c = res[i]+shift;
            while (c > 'z') {
                c = c - 26;
            }
            res[i] = (char)c;
        }

        return new String(res);
    }
}
