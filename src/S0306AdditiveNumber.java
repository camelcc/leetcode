import java.util.ArrayList;
import java.util.List;

public class S0306AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (i == num.length()-1) {
                continue;
            }
            // first = 0

            for (int j = i+1; j < num.length(); j++) {
                if (j == num.length()-1) {
                    continue;
                }
                // second = i+1
                // sum = j+1
                if (isAdditiveNumber(num, 0, i+1, j+1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAdditiveNumber(String num, int first, int second, int sum) {
        assert first < second;
        assert second < sum;
        assert sum < num.length();

        String a = num.substring(first, second);
        String b = num.substring(second, sum);
        String remains = num.substring(sum);
        if ((a.length() > 1 && a.startsWith("0")) ||
                (b.length() > 1 && b.startsWith("0")) ||
                (remains.length() > 1 && remains.startsWith("0"))) {
            return false;
        }

        String add = add(a, b);
        if (!remains.startsWith(add)) {
            return false;
        }
        if (remains.equals(add)) {
            return true;
        }

        return isAdditiveNumber(num, second, sum, sum + add.length());
    }

    private String add(String a, String b) {
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();

        List<Character> add = new ArrayList<>();
        char c = '0';
        for (int i = 0; i < Math.max(aArray.length, bArray.length); i++) {
            int av = aArray.length > i ? aArray[aArray.length-1-i] - '0' : 0;
            int bv = bArray.length > i ? bArray[bArray.length-1-i] - '0' : 0;
            int cv = c - '0';

            int s = av+bv+cv;
            if (s >= 10) {
                c = (char)('0' + s/10);
                add.add(0, (char)(s%10+'0'));
            } else {
                c = '0';
                add.add(0, (char)(s + '0'));
            }
        }
        if (c != '0') {
            add.add(0, c);
        }
        StringBuilder sb = new StringBuilder();
        for (char ac : add) {
            sb.append(ac);
        }
        return sb.toString();
    }
}
