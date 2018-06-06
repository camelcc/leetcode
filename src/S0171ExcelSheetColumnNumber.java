public class S0171ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'A' + 1;
            res = 26 * res + c;
        }
        return res;
    }
}
