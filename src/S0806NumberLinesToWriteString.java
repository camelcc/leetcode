public class S0806NumberLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        int lines = 1;
        int width = 0;
        for (char c : S.toCharArray()) {
            if (width + widths[c-'a'] > 100) {
                lines++;
                width = widths[c-'a'];
            } else {
                width += widths[c-'a'];
            }
        }
        return new int[]{lines, width};
    }
}
