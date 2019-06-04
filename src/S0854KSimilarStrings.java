import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class S0854KSimilarStrings {
    public int kSimilarity(String A, String B) {
        LinkedList<String> bfs = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        bfs.add(A);
        visited.add(A);
        int K = 0;
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                String str = bfs.remove();
                if (str.equals(B)) {
                    return K;
                }
                for (String n : neighbours(str, B)) {
                    if (!visited.contains(n)) {
                        bfs.add(n);
                        visited.add(n);
                    }
                }
            }
            K++;
        }

        return -1;
    }

    private List<String> neighbours(String S, String B) {
        int i = 0;
        char[] arr = S.toCharArray();
        while (i < arr.length) {
            if (arr[i] != B.charAt(i)) {
                break;
            }
            i++;
        }

        ArrayList<String> res = new ArrayList<>();
        for (int j = i+1; j < B.length(); j++) {
            if (B.charAt(j) == arr[i]) {
                swap(arr, i, j);
                res.add(new String(arr));
                swap(arr, i, j);
            }
        }

        return res;
    }

    private void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
