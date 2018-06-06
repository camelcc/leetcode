public class S0168ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        int i = n-1;
        res.insert(0, (char)('A' + i%26));
        if (i <= 25) {
            return res.toString();
        }
        i = i/26;

        while (i > 0) {
            res.insert(0, (char)('A' + (i-1)%26));
            if (i <= 26) {
                break;
            } else {
                i = i/26;
            }
        }
        return res.toString();
    }
}
