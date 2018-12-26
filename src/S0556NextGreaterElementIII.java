import java.util.ArrayList;
import java.util.List;

public class S0556NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        if (n == Integer.MAX_VALUE) {
            return -1;
        }
        List<Integer> max = new ArrayList<>();
        int m = Integer.MAX_VALUE;
        while (m != 0) {
            max.add(0, m%10);
            m = m/10;
        }

        List<Integer> digits = new ArrayList<>();
        m = n;
        while (m != 0) {
            digits.add(0, m%10);
            m = m/10;
        }
        int i = digits.size()-1;
        int md = digits.get(i);
        i--;
        while (i >= 0) {
            if (digits.get(i) < md) {
                break;
            }
            md = digits.get(i);
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int d = digits.get(i);
        int si = -1;
        for (int j = i+1; j < digits.size(); j++) {
            if (digits.get(j) <= d) {
                continue;
            }
            if (si == -1) {
                si = j;
            } else {
                if (digits.get(si) > digits.get(j)) {
                    si = j;
                }
            }
        }
        digits.set(i, digits.get(si));
        digits.set(si, d);
        i++;
        int[] ds = new int[10];
        for (int j = i; j < digits.size(); j++) {
            ds[digits.get(j)]++;
        }
        while (digits.size() > i) {
            digits.remove(i);
        }
        for (int j = 0; j < 10; j++) {
            if (ds[j] == 0) {
                continue;
            }
            while (ds[j] != 0) {
                digits.add(j);
                ds[j]--;
            }
        }

        if (digits.size() == max.size()) {
            for (int j = 0; j < max.size(); j++) {
                if (max.get(j) < digits.get(j)) {
                    return -1;
                }
            }
        }
        int res = 0;
        while (!digits.isEmpty()) {
            int t = digits.remove(0);
            res = res * 10 + t;
        }
        return res;
    }
}
