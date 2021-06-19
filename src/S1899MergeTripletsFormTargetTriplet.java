import java.util.Arrays;
import java.util.Comparator;

public class S1899MergeTripletsFormTargetTriplet {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Integer[] index = new Integer[triplets.length];
        for (int i = 0; i < triplets.length; i++) {
            index[i] = i;
        }

        int range = binarySearch(triplets, index, triplets.length, target, 0);
        if (range == -1) {
            return false;
        }
        range = binarySearch(triplets, index, range+1, target, 1);
        if (range == -1) {
            return false;
        }
        range = binarySearch(triplets, index, range+1, target, 2);
        if (range == -1) {
            return false;
        }

        // [0, range]
        Arrays.sort(index, 0, range+1, Comparator.comparingInt(o -> triplets[o][1]));
        if (triplets[index[range]][1] != target[1]) {
            return false;
        }
        Arrays.sort(index, 0, range+1, Comparator.comparingInt(o -> triplets[o][0]));
        if (triplets[index[range]][0] != target[0]) {
            return false;
        }
        return true;
    }

    private int binarySearch(int[][] triplets, Integer[] index, int end, int[] target, int i) {
        Arrays.sort(index, 0, end, Comparator.comparingInt(o -> triplets[o][i]));
        if (triplets[index[0]][i] > target[i]) {
            return -1;
        }
        int lo = 0, hi = end;
        while (lo < hi) {
            int mid = lo+(hi-lo)/2;
            if (triplets[index[mid]][i] <= target[i]) {
                if (lo == mid) {
                    break;
                }
                lo = mid;
            } else {
                hi = mid;
            }
        }
        if (triplets[index[lo]][i] != target[i]) {
            return -1;
        }
        return lo;
    }
}
