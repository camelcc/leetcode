import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S1200MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i+1] - arr[i] > min) {
                continue;
            }

            if (arr[i+1]-arr[i] < min) {
                min = arr[i+1]-arr[i];
                res.clear();
            }
            List<Integer> t = new ArrayList<>();
            t.add(arr[i]);
            t.add(arr[i+1]);
            res.add(t);
        }
        return res;
    }
}
