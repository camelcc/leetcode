import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class S0402RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num.isEmpty()) {
            return "0";
        }
        if (k == 0) {
            return num;
        }
        if (k >= num.length()) {
            return "0";
        }

        String res = remove(num, k);
        while (res.startsWith("0")) {
            res = res.substring(1);
        }
        return res.isEmpty() ? "0" : res;
    }

    private String remove(String num, int k) {
        assert !num.isEmpty();
        assert k > 0;
        assert k < num.length();

        String res = "";
        for (char firstDigit = '0'; firstDigit <= '9'; firstDigit++) {
            int firstDigitIndex = num.indexOf(firstDigit);
            if (firstDigitIndex == -1) {
                continue;
            }

            if (firstDigitIndex <= k) {
                // remove all chars before index
                if (k-firstDigitIndex == 0) {
                    res = num.substring(firstDigitIndex);
                } else {
                    String remains = num.substring(firstDigitIndex + 1);
                    int remainsK = k - firstDigitIndex;
                    if (remains.length() == remainsK) {
                        res = String.valueOf(num.charAt(firstDigitIndex));
                    } else {
                        res = num.charAt(firstDigitIndex) + remove(remains, remainsK);
                    }
                }
                break;
            }
        }
        return res;
    }

    public static class Combine {
        public String pre;
        public String str;
        public int num;

        public Combine(String pre, String str, int num) {
            this.pre = pre;
            this.str = str;
            this.num = num;
        }
    }

    public String _removeKdigits(String num, int k) {
        while (!num.isEmpty() && num.startsWith("0")) {
            num = num.substring(1);
        }
        if (num.isEmpty()) {
            return "0";
        }
        if (k == 0) {
            return num;
        }
        if (k >= num.length()) {
            return "0";
        }

        for (char firstDigit = '0'; firstDigit <= '9'; firstDigit++) {
            int firstDigitIndex = num.indexOf(firstDigit);
            if (firstDigitIndex == -1) {
                continue;
            }

            if (firstDigitIndex <= k) {
                // remove all chars before index
                return removeKdigits(num.substring(firstDigitIndex), k-firstDigitIndex);
            } else {

            }
        }







        List<String> res = new ArrayList<>();
        Stack<Combine> comb = new Stack<>();

        int firstZero = num.indexOf('0');
        if (firstZero != -1 && firstZero <= k) {

        }

        comb.push(new Combine("", num, k));
        while (!comb.isEmpty()) {
            Combine c = comb.pop();
            String pre = c.pre;
            String str = c.str;
            int n = c.num;
            assert n > 0;
            assert n < str.length();

            StringBuilder sb = new StringBuilder(str);
            char first = sb.charAt(0);
            sb = sb.deleteCharAt(0);
            // pick
            String p = pre + first;
            if (sb.length() == n) {
                res.add(p);
            } else {
                comb.push(new Combine(p, sb.toString(), n));
            }

            // remove
            if (n == 1) {
                res.add(pre + sb.toString());
            } else {
                comb.push(new Combine(pre, sb.toString(), n-1));
            }
        }

        res.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        String smallest = res.get(0);
        while (smallest.startsWith("0")) {
            smallest = smallest.substring(1);
        }
        return smallest.isEmpty() ? "0" : smallest;
    }
}
