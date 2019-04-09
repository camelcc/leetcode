import java.util.Arrays;
import java.util.Comparator;

public class S0870AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        Integer[] ai = new Integer[A.length];
        Integer[] bi = new Integer[B.length];
        for (int i = 0; i < A.length; i++) {
            ai[i] = i;
        }
        for (int i = 0; i < B.length; i++) {
            bi[i] = i;
        }
        Arrays.sort(ai, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return A[o1] - A[o2];
            }
        });
        Arrays.sort(bi, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return B[o1] - B[o2];
            }
        });

        int[] res = new int[A.length];
        int bright = B.length-1;
        int aleft = 0;
        int aright = A.length-1;

        while (bright >= 0) {
            int c = -1;
            if (B[bi[bright]] >= A[ai[aright]]) {
                c = aleft++;
            } else {
                c = aright--;
            }

            res[bi[bright]] = A[ai[c]];
            bright--;
        }
        return res;
    }
}
