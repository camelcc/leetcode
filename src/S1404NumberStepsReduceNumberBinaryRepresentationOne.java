public class S1404NumberStepsReduceNumberBinaryRepresentationOne {
    public int numSteps(String s) {
        if (s.equals("1")) {
            return 0;
        }
        if (s.endsWith("0")) {
            return 1 + numSteps(s.substring(0, s.length()-1));
        }
        // XXX1
        StringBuilder sb = new StringBuilder();
        int i = s.length()-2;
        int sup = 1;
        while (i >= 0) {
            char c = s.charAt(i);
            if (c == '1' && sup == 1) {
                sb.append('0');
            } else if (c == '1' && sup == 0) {
                sb.append('1');
            } else if (c == '0' && sup == 1) {
                sb.append('1');
                sup = 0;
            } else if (c == '0' && sup == 0) {
                sb.append('0');
            }
            i--;
        }
        if (sup == 1) {
            sb.append('1');
        }
        sb.reverse();
        return 2 + numSteps(sb.toString());
    }
}
