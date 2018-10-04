public class S0067AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ia = a.length()-1;
        int ib = b.length()-1;
        int c = 0;
        while (ia >= 0 || ib >= 0) {
            int s = c;
            if (ia >= 0) {
                s += (a.charAt(ia) == '0' ? 0 : 1);
                ia--;
            }
            if (ib >= 0) {
                s += (b.charAt(ib) == '0' ? 0 : 1);
                ib--;
            }
            sb.append(s % 2 == 0 ? '0' : '1');
            c = s/2;
        }
        if (c != 0) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
