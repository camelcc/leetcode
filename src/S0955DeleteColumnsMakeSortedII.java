import java.util.Arrays;

public class S0955DeleteColumnsMakeSortedII {
    public int minDeletionSize(String[] A) {
        boolean[] equal = new boolean[A.length];
        Arrays.fill(equal, true);

        int res = 0;
        for (int i = 0; i < A[0].length(); i++) {
            boolean[] nextEqual = Arrays.copyOf(equal, equal.length);
            int j = 0;
            while (j < A.length-1) {
                if (!equal[j]) {
                    j++;
                    continue;
                }

                int cur = A[j].charAt(i);
                char next = A[j+1].charAt(i);
                if (cur > next) {
                    res++;
                    break;
                }
                if (cur < next) {
                    nextEqual[j] = false;
                }
                j++;
            }
            if (j == A.length-1) {
                equal = nextEqual;
            }
        }
        return res;
    }
}
