import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/valid-arrangement-of-pairs/discuss/1612936/JAVA-Graph-%2B-Hierholzer
public class S2097ValidArrangementPairs {
    Map<Integer, List<Integer>> graph;
    Map<Integer, Integer> degree;
    List<int[]> ans;

    public int[][] validArrangement(int[][] pairs) {
        graph = new HashMap<>();
        ans = new ArrayList<>();
        degree = new HashMap<>();

        //build graph
        buildGraph(pairs);

        //select a start
        int start = -1;
        for(Integer i : degree.keySet())
        {
            if(degree.get(i) > 0)
            {
                start = i;
                break;
            }
        }

        if(start == -1) start = pairs[0][0];

        //dfs Hierholzer
        dfs(start);

        int size = ans.size();
        int[][] range = new int[size][2];
        for(int i=0; i<size; i++)
        {
            range[i][0] = ans.get(size-1-i)[0];
            range[i][1] = ans.get(size-1-i)[1];
        }
        return range;
    }

    private void buildGraph(int[][] pairs)
    {
        for(int[] pair : pairs)
        {
            graph.putIfAbsent(pair[0], new ArrayList<>());
            List<Integer> edges = graph.get(pair[0]);
            edges.add(pair[1]);

            int cnt = degree.getOrDefault(pair[0], 0);
            degree.put(pair[0], cnt+1);
            cnt = degree.getOrDefault(pair[1], 0);
            degree.put(pair[1], cnt-1);
        }
    }

    private void dfs(int start)
    {
        List<Integer> edges = graph.get(start);
        if(edges == null) return;
        while(edges.size() > 0)
        {
            int next = edges.get(edges.size()-1);
            edges.remove(edges.size()-1);
            dfs(next);
            ans.add(new int[]{start, next});
        }
    }
}
