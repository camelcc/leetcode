public class S0845LongestMountainArray {
    public int longestMountain(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        int res = 0;
        int left = 0;
        while (left < A.length-2) {
            if (A[left+1] <= A[left]) {
                left++;
                continue;
            }

            int mid = left+1;
            while (mid < A.length && A[mid] > A[mid-1]) {
                mid++;
            }
            mid--;
            if (mid == A.length-1) {
                break;
            }
            assert mid > left && mid+1 < A.length;
            assert A[mid] >= A[mid+1];
            if (A[mid] == A[mid+1]) {
                left = mid+1;
                continue;
            }

            int right = mid+1;
            while (right < A.length && A[right] < A[right-1]) {
                right++;
            }
            right--;
            assert right > mid;
            res = Math.max(res, right-left+1);
            left = right;
        }
        return res;
    }
}
