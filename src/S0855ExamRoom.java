import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S0855ExamRoom {
    public static class ExamRoom {
        List<Integer> seated;
        int N;

        public ExamRoom(int N) {
            seated = new ArrayList<>();
            this.N = N;
        }

        public int seat() {
            if (seated.isEmpty()) {
                seated.add(0);
                return 0;
            }

            int res = 0;
            int max = seated.get(0);
            for (int i = 1; i < seated.size(); i++) {
                if ((seated.get(i)-seated.get(i-1))/2 > max) {
                    max = (seated.get(i)-seated.get(i-1))/2;
                    res = seated.get(i-1)+max;
                }
            }
            if (N-1-seated.get(seated.size()-1) > max) {
                res = N-1;
            }
            int p = Collections.binarySearch(seated, res);
            assert p < 0;
            p = -(p+1);
            seated.add(p, res);
            return res;
        }

        public void leave(int p) {
            int pos = Collections.binarySearch(seated, p);
            assert pos >= 0;
            seated.remove(pos);
        }
    }
}
