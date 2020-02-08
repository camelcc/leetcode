import java.util.*;

public class S1345JumpGameIV {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            pos.putIfAbsent(arr[i], new ArrayList<>());
            pos.get(arr[i]).add(i);
        }

        int res = 0;

        boolean[] visited = new boolean[arr.length];

        HashSet<Integer> current = new HashSet<>();
        current.add(arr.length-1);
        visited[arr.length-1] = true;

        while (!current.isEmpty()) {
            if (current.contains(0)) {
                return res;
            }

            HashSet<Integer> next = new HashSet<>();
            for (int p : current) {
                for (int n : pos.get(arr[p])) {
                    if (!visited[n]) {
                        next.add(n);
                        visited[n] = true;
                    }
                }
                if (p+1 < arr.length && !visited[p+1]) {
                    next.add(p+1);
                    visited[p+1] = true;
                }
                if (p-1 >= 0 && !visited[p-1]) {
                    next.add(p-1);
                    visited[p-1] = true;
                }
            }

            res++;
            current = next;
        }

        return res;
    }
}
