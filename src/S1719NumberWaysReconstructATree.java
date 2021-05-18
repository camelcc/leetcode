import java.util.*;

// https://leetcode.com/problems/number-of-ways-to-reconstruct-a-tree/discuss/1027116/java-dfs-similar-to-topology-sorting
public class S1719NumberWaysReconstructATree {
    boolean multiple = false;
    //if a node has been built successfully, mark it, otherwise it may fail in other paths
    //ie.[[3,5],[4,5],[2,5],[1,5],[1,4],[2,4]]
    //we visit 5->4->1->2, all good, if not marked, the second time, we visit 5->4->2, failed
    boolean[] succeed = new boolean[501];
    public int checkWays(int[][] pairs) {
        Map<Integer, Set<Integer>> map = new HashMap();
        int root = -1;
        //build connections from pairs
        for(int[] pair : pairs){
            map.putIfAbsent(pair[0], new HashSet());
            map.putIfAbsent(pair[1], new HashSet());
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }
        int n = map.keySet().size();
        //root node should have n-1 connections
        //if multiple nodes can be root, it doesn't matter which one we pick
        //it only affects whether  we have multiple results or not
        //we will determin multiple in dfs function
        for(Map.Entry<Integer, Set<Integer>> e : map.entrySet()){
            if(e.getValue().size() == n-1){
                root = e.getKey();
                break;
            }
        }
        if(root == -1) return 0;
        Set<Integer> ancestors = new HashSet();
        ancestors.add(root);
        if(!dfs(map, root, ancestors)) return 0;
        return multiple ? 2 : 1;
    }
    public boolean dfs(Map<Integer, Set<Integer>> map, int parent, Set<Integer> ancestors){
        Set<Integer> children = map.get(parent);
        List<Integer> legitChildren = new ArrayList();
        //filter out children which have been marked as ancestors and succeefully built before
        for(int child : children){
            if(ancestors.contains(child) || succeed[child]) continue;
            Set<Integer> connections = map.get(child);
            for(int anc : ancestors){
                if(!connections.contains(anc))
                    return false;
            }
            legitChildren.add(child);
        }
        //sort legit children by pairs it has, we always prefer to visit node with more pairs
        //because parent has more or equal number of pairs compares with its children
        //if two nodes have same number of pairs, then it doesn't matter which one we visit first
        //same number of pairs means we can swap them and end up with multiple ways
        Collections.sort(legitChildren, (a,b)->(map.get(b).size()-map.get(a).size()));
        int idx = 0;
        for(int next : legitChildren){
            if(map.get(next).size() == children.size())
                multiple = true;
            ancestors.add(next);
            if(!dfs(map, next, ancestors))
                return false;
            ancestors.remove(next);
        }
        return succeed[parent] = true;
    }
}
