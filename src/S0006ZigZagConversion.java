import java.util.Arrays;

public class S0006ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int j = 0; j < numRows; j++) {
            sb[j] = new StringBuilder();
        }

        boolean down = true;
        int r = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (down) {
                if (r == numRows) {
                    down = false;
                    r = numRows - 2;
                } else {
                    sb[r++].append(c);
                    i++;
                }
            } else {
                if (r == 0) {
                    down = true;
                } else {
                    sb[r--].append(c);
                    i++;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < sb.length; j++) {
            res.append(sb[j].toString());
        }
        return res.toString();
    }
}
