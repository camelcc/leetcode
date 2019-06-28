public class S0927ThreeEqualParts {
    public int[] threeEqualParts(int[] A) {
        int first = 0;
        while (first < A.length && A[first] == 0) {
            first++;
        }
        if (first == A.length) {
            return new int[] {0, A.length-1};
        }

        int f = first;
        while (2*(f-first+1) <= A.length-f-1) {
            // [first, f] == [f+1, len-1]
            int second = f+1;
            while (second < A.length && A[second] == 0) {
                second++;
            }
            if (second == A.length || A.length-second < 2*(f-first+1)) {
                f++;
                continue;
            }
            int fi = first, si = second;
            while (fi <= f && si < A.length) {
                if (A[fi] != A[si]) {
                    break;
                }
                fi++;
                si++;
            }
            if (fi <= f) {
                f++;
                continue;
            }

            int third = si;
            while (third < A.length && A[third] == 0) {
                third++;
            }
            if (third == A.length || A.length-third != (f-first+1)) {
                f++;
                continue;
            }
            fi = first;
            int ti = third;
            while (fi <= f && ti < A.length) {
                if (A[fi] != A[ti]) {
                    break;
                }
                fi++;
                ti++;
            }
            if (fi <= f) {
                f++;
                continue;
            }
            return new int[]{f, si};
        }

        return new int[]{-1, -1};
    }
}
