import java.util.HashMap;

public class S2053KDistinctStringArray {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> cnt = new HashMap<>();
        for (String a : arr) {
            cnt.put(a, cnt.getOrDefault(a, 0)+1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (cnt.get(arr[i]) != 1) {
                continue;
            }
            if (k == 1) {
                return arr[i];
            }
            k--;
        }
        return "";
    }
}
