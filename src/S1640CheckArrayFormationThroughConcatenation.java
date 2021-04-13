import java.util.Arrays;
import java.util.Comparator;

public class S1640CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Arrays.sort(pieces, Comparator.comparingInt(o -> o[0]));
        int p = 0;
        while (p < arr.length) {
            int v = arr[p];
            int i = Arrays.binarySearch(pieces, new int[]{v}, Comparator.comparingInt(o -> o[0]));
            if (i < 0) {
                return false;
            }
            if (arr.length-p < pieces[i].length) {
                return false;
            }
            for (int j = 0; j < pieces[i].length; j++) {
                if (pieces[i][j] != arr[p]) {
                    return false;
                }
                p++;
            }
        }
        return true;
    }
}
