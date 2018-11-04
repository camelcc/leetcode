import java.util.HashMap;

public class S0166FractionRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean negative = (numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0);

        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        String res = String.valueOf(num / den);
        num = num % den;
        if (num == 0) {
            return negative ? ("-" + res) : res;
        }
        res += '.';
        num *= 10;

        StringBuilder sb = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<>();
        while (num != 0 && !map.containsKey(num)) {
            if (num < den) {
                map.put(num, sb.length());
                sb.append('0');
                num *= 10;
            } else {
                map.put(num, sb.length());
                sb.append(String.valueOf(num / den));
                num = 10 * (num % den);
            }
        }
        if (num == 0) {
            res += sb.toString();
        } else {
            assert map.containsKey(num);
            if (map.containsKey(num)) {
                sb.insert(map.get(num), "(");
                sb.append(')');
            }
            res += sb.toString();
        }
        return negative ? ("-" + res) : res;
    }
}
