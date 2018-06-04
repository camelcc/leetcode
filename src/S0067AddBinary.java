import java.util.Stack;

public class S0067AddBinary {
    public String addBinary(String a, String b) {
        int ai = a.length()-1, bi = b.length()-1;
        char added = '0';
        Stack<Character> sum = new Stack<>();
        while (ai >= 0 || bi >= 0) {
            int s = 0;
            s = s + (added == '1' ? 1 : 0);
            if (ai < 0) {
                s = s + (b.charAt(bi--) == '1' ? 1 : 0);
            } else if (bi < 0) {
                s = s + (a.charAt(ai--) == '1' ? 1 : 0);
            } else {
                s = s + (a.charAt(ai--) == '1' ? 1 : 0);
                s = s + (b.charAt(bi--) == '1' ? 1 : 0);
            }

            if (s == 0) {
                sum.push('0');
                added = '0';
            } else if (s == 1) {
                sum.push('1');
                added = '0';
            } else if (s == 2) {
                sum.push('0');
                added = '1';
            } else if (s == 3) {
                sum.push('1');
                added = '1';
            }
        }
        if (added == '1') {
            sum.push('1');
        }
        StringBuilder res = new StringBuilder();
        while (!sum.empty()) {
            res.append(sum.pop());
        }
        return res.toString();
    }
}
