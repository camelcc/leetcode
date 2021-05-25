public class S1758MinimumChangesMakeAlternatingBinaryString {
    public int minOperations(String s) {
        int zero = 0, one = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int tzero = 0, tone = 0;
            if (c == '0') {
                tzero = Math.min(i-zero, one);
                tone = 1+Math.min(zero, i-one);
            } else if (c == '1') {
                tzero = 1+Math.min(i-zero, one);
                tone = Math.min(zero, i-one);
            }
            zero = tzero;
            one = tone;
        }
        return Math.min(zero, one);
    }
}
