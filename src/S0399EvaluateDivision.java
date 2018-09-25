import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class S0399EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] res = new double[queries.length];
        HashSet<String> symbols = new HashSet<>();
        for (String[] equal : equations) {
            for (String s : equal) {
                symbols.add(s);
            }
        }

        HashMap<String, HashMap<String, Double>> dist = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            String src = query[0];
            String dst = query[1];
            if (!symbols.contains(src) || !symbols.contains(dst)) {
                res[i] = -1.0;
                continue;
            }

            if (!dist.containsKey(src)) {
                HashMap<String, Double> vals = new HashMap<>();
                vals.put(src, 1.0);
                dist.put(src, vals);
            }

            if (dist.get(src).containsKey(dst)) {
                res[i] = dist.get(src).get(dst);
            } else {
                res[i] = calc(src, dst, equations, values, dist.get(src));
            }
        }
        return res;
    }

    private double calc(String src, String dst, String[][] equations, double[] values, HashMap<String, Double> visited) {
        List<String> queue = new ArrayList<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            String s = queue.remove(0);
            for (String adj : adj(s, equations, values, visited)) {
                if (adj.equals(dst)) {
                    return visited.get(adj);
                } else {
                    queue.add(adj);
                }
            }
        }
        return -1.0;
    }

    private List<String> adj(String a, String[][] equations, double[] values, HashMap<String, Double> dist) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equal = equations[i];
            if (equal[0].equals(a)) {
                if (!dist.containsKey(equal[1])) {
                    dist.put(equal[1], dist.get(equal[0]) * values[i]);
                    res.add(equal[1]);
                }
            } else if (equal[1].equals(a)) {
                if (!dist.containsKey(equal[0])) {
                    dist.put(equal[0], dist.get(equal[1]) / values[i]);
                    res.add(equal[0]);
                }
            }
        }
        return res;
    }
}
