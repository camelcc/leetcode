public class S0640SolveEquation {
    public String solveEquation(String equation) {
        if (equation == null || equation.isEmpty() || !equation.contains("=") || !equation.contains("x")) {
            return "No solution";
        }
        String[] e = equation.split("=");
        int[] left = simplify(e[0]);
        int[] right = simplify(e[1]);
        int x = left[0]-right[0];
        int v = right[1]-left[1];
        if (x == 0) {
            return v == 0 ? "Infinite solutions" : "No solution";
        } else {
            return "x=" + (v/x);
        }
    }

    private int[] simplify(String express) {
        int xv = 0;
        int dv = 0;

        boolean x = false;
        boolean positive = true;
        StringBuilder sb = new StringBuilder();
        for (char c : express.toCharArray()) {
            if (c == '-' || c == '+') {
                if (sb.length() != 0) {
                    int d = Integer.valueOf(sb.toString());
                    sb = new StringBuilder();
                    if (x) {
                        xv += positive ? d : -d;
                    } else {
                        dv += positive ? d : -d;
                    }
                }
                positive = (c == '+');
                x = false;
            } else if (c == 'x') {
                if (sb.length() == 0) {
                    sb.append('1');
                }
                x = true;
            } else { // digits
                sb.append(c);
            }
        }
        int d = Integer.valueOf(sb.toString());
        if (x) {
            xv += positive ? d : -d;
        } else {
            dv += positive ? d : -d;
        }
        return new int[]{xv, dv};
    }
}
