import java.util.HashMap;
import java.util.HashSet;

public class S2201CountArtifactsThatCanBeExtracted {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        HashSet<Integer>[] remains = new HashSet[artifacts.length];
        HashMap<Integer, Integer> reverse = new HashMap<>();
        for (int i = 0; i < artifacts.length; i++) {
            remains[i] = new HashSet<>();
            for (int r = artifacts[i][0]; r <= artifacts[i][2]; r++) {
                for (int c = artifacts[i][1]; c <= artifacts[i][3]; c++) {
                    int p = r*n+c;
                    remains[i].add(p);
                    reverse.put(p, i);
                }
            }
        }


        int res = 0;
        for (int[] d : dig) {
            int p = d[0]*n+d[1];
            if (!reverse.containsKey(p)) {
                continue;
            }
            int t = reverse.remove(p);
            remains[t].remove(p);
            if (remains[t].isEmpty()) {
                res++;
            }
        }
        return res;
    }
}
