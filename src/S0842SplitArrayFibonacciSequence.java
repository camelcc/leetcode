import java.util.ArrayList;
import java.util.List;

public class S0842SplitArrayFibonacciSequence {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        if (S.length() < 3) {
            return res;
        }

        String t;
        for (int first = 1; first < S.length()-2; first++) {
            t = S.substring(0, first);
            if (t.length() > 1 && t.startsWith("0")) {
                break;
            }
            long f0 = Long.valueOf(t);
            if (f0 > Integer.MAX_VALUE) {
                break;
            }
            for (int second = first+1; second < S.length()-1; second++) {
                t = S.substring(first, second);
                if (t.length() > 1 && t.startsWith("0")) {
                    break;
                }
                long f1 = Long.valueOf(t);
                if (f1 > Integer.MAX_VALUE) {
                    break;
                }
                if (f0 + f1 > Integer.MAX_VALUE) {
                    break;
                }
                for (int third = second+1; third <= S.length(); third++) {
                    t = S.substring(second, third);
                    if (t.length() > 1 && t.startsWith("0")) {
                        break;
                    }
                    long f2 = Long.valueOf(t);
                    if (f2 > Integer.MAX_VALUE) {
                        break;
                    }
                    if (f0+f1 != f2) {
                        continue;
                    }

                    res.clear();
                    res.add((int)f0);
                    res.add((int)f1);
                    res.add((int)f2);
                    long t0 = f0;
                    long t1 = f1;
                    long t2 = f2;
                    t = S.substring(third);
                    while (!t.isEmpty()) {
                        t0 = t1;
                        t1 = t2;
                        t2 = t0+t1;
                        if (t2 > Integer.MAX_VALUE) {
                            break;
                        }
                        String n = String.valueOf(t2);
                        if (!t.startsWith(n)) {
                            break;
                        }
                        res.add((int)t2);
                        t = t.substring(n.length());
                    }
                    if (!t.isEmpty()) {
                        continue;
                    }
                    return res;
                }
            }
        }
        return new ArrayList<>();
    }
}
