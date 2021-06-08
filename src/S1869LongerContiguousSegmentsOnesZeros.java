public class S1869LongerContiguousSegmentsOnesZeros {
    public boolean checkZeroOnes(String s) {
        int one = 0, zero = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int j = i+1;
            while (j < s.length() && s.charAt(j) == c) {
                j++;
            }
            int len = j-i;
            if (c == '0') {
                zero = Math.max(zero, len);
            } else if (c == '1') {
                one = Math.max(one, len);
            }
            i = j;
        }
        return one > zero;
    }
}
