import java.util.Arrays;

public class S0006ZigZagConversion {
    public String convert(String s, int numRows) {
        assert numRows > 0;
        if (numRows == 1 || s.length() <= 1) {
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int row = 0;
        boolean down = true;
        for (char c : s.toCharArray()) {
            sb[row].append(c);
            if (down) {
                if (row == numRows-1) {
                    down = false;
                    row = row-1;
                } else {
                    row++;
                }
            } else {
                if (row == 0) {
                    down = true;
                    row = 1;
                } else {
                    row--;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder t : sb) {
            res.append(t);
        }
        return res.toString();
    }
}
