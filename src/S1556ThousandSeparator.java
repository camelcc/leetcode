import java.util.StringJoiner;

public class S1556ThousandSeparator {
    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();
        int c = 0;
        while (n != 0) {
            char d = (char)(n%10 + '0');
            sb.insert(0, d);
            c++;
            n = n/10;
            if (c == 3 && n > 0) {
                sb.insert(0, '.');
                c = 0;
            }
        }
        if (sb.length() == 0) {
            sb.append('0');
        }
        return sb.toString();
    }
}
