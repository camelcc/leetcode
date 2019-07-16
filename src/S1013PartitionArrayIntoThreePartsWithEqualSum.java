public class S1013PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum%3 != 0) {
            return false;
        }
        long t1 = sum/3, t2 = t1+t1;
        int p1 = -1;
        sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum == t2) {
                if (p1 != -1) {
                    if (i < A.length-1) {
                        return true;
                    }
                }
            }
            if (sum == t1) {
                if (p1 == -1) {
                    p1 = i;
                }
            }
        }
        return false;
    }
}
