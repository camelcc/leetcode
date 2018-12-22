public class S0537ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        int ar = 0, ai = 0, br = 0, bi = 0;
        if (a.contains("+")) {
            ar = Integer.valueOf(a.substring(0, a.indexOf('+')));
            ai = Integer.valueOf(a.substring(a.indexOf('+') + 1, a.length()-1));
        } else {
            ar = Integer.valueOf(a);
        }
        if (b.contains("+")) {
            br = Integer.valueOf(b.substring(0, b.indexOf('+')));
            bi = Integer.valueOf(b.substring(b.indexOf('+') + 1, b.length()-1));
        } else {
            br = Integer.valueOf(b);
        }
        int rr = ar * br - ai * bi;
        int ri = ar * bi + ai * br;
        return String.valueOf(rr) + '+' + String.valueOf(ri) + 'i';
    }
}
