public class S0922SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int even = 0, odd = 1;
        while (even < A.length && odd < A.length) {
            while (even < A.length && A[even]%2 == 0) {
                even += 2;
            }
            while (odd < A.length && A[odd]%2 == 1) {
                odd += 2;
            }
            if (even < A.length && odd < A.length) {
                int t = A[even];
                A[even] = A[odd];
                A[odd] = t;
                even += 2;
                odd += 2;
            }
        }
        return A;
    }
}
