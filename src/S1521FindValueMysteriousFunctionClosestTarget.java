import java.util.Arrays;

public class S1521FindValueMysteriousFunctionClosestTarget {
    public int closestToTarget(int[] arr, int target) {
        int[][] zeros = new int[arr.length][32];
        int[] current = new int[32];
        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            for (int j = 0; j < 32; j++) {
                current[j] += ((v&(0x1 << j)) == 0 ? 1 : 0);
            }
            zeros[i] = Arrays.copyOf(current, current.length);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i], min = (i == arr.length-1) ? arr[i] : func(zeros, i, arr.length-1);
            if (target > max) {
                res = Math.min(res, target-max);
            } else if (target < min) {
                res = Math.min(res, min-target);
            } else if (target == max || target == min) {
                return 0;
            } else { // min < target < max
                res = Math.min(res, target-min);
                res = Math.min(res, max-target);
                if (i == arr.length-1) {
                    res = Math.min(res, Math.abs(arr[i]-target));
                } else {
                    res = Math.min(res, binarySearch(zeros, target, i));
                }
            }
        }
        return res;
    }

    private int binarySearch(int[][] zeros, int target, int p) {
        int l = p+1, r = zeros.length-1;
        while (l < r) {
            int mid = l + (r-l)/2;
            int v = func(zeros, p, mid);
            if (v <= target) {
                if (l == mid) {
                    break;
                }
                r = mid;
            } else {
                l = mid+1;
            }
        }
        // v < target, l
        int res = Math.min(Math.abs(func(zeros, p, l)-target), Math.abs(func(zeros, p, l-1)-target));
        return res;
    }

    private int func(int[][] zeros, int l, int r) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((l == 0 ? 0 : zeros[l-1][i]) == zeros[r][i]) {
                res += (0x1 << i);
            }
        }
        return res;
    }
}
