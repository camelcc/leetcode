import java.util.ArrayList;
import java.util.List;

public class S0401BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        ArrayList<Integer> hours = new ArrayList<>();
        hours.add(1);
        hours.add(2);
        hours.add(4);
        hours.add(8);
        ArrayList<Integer> mins = new ArrayList<>();
        mins.add(1);
        mins.add(2);
        mins.add(4);
        mins.add(8);
        mins.add(16);
        mins.add(32);

        List<String> res = new ArrayList<>();
        for (int i = 0; i <= 4; i++) {
            List<Integer> h = select(i, hours, 11);
            if (h.isEmpty()) {
                continue;
            }
            List<Integer> m = select(num-i, mins, 59);
            if (m.isEmpty()) {
                continue;
            }

            for (int th : h) {
                for (int tm : m) {
                    String sm = String.valueOf(tm);
                    if (tm <= 9) {
                        sm = "0" + sm;
                    }
                    res.add(String.valueOf(th) + ":" + sm);
                }
            }
        }
        return res;
    }

    private List<Integer> select(int num, ArrayList<Integer> candidates, int max) {
        List<Integer> res = new ArrayList<>();
        if (num < 0 || num > candidates.size()) {
            return res;
        }

        if (num == 0) {
            res.add(0);
            return res;
        }
        if (num == candidates.size()) {
            int sum = 0;
            for (int c : candidates) {
                sum += c;
            }
            if (sum <= max) {
                res.add(sum);
            }
            return res;
        }

        for (int i = 0; i < candidates.size(); i++) {
            int selected = candidates.get(i);
            ArrayList<Integer> remains = new ArrayList<>();
            for (int k = i+1; k < candidates.size(); k++) {
                remains.add(candidates.get(k));
            }
            List<Integer> candidate = select(num - 1, remains, max);
            for (int c : candidate) {
                if (c + selected <= max) {
                    if (!res.contains(c+selected)) {
                        res.add(c + selected);
                    }
                }
            }
        }

        return res;
    }
}
