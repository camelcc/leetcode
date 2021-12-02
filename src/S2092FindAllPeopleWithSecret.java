import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// https://leetcode.com/problems/find-all-people-with-secret/discuss/1605331/Java-Solution-Union-Find
public class S2092FindAllPeopleWithSecret {
    int[] parent;
    int[] sz; // the size of children nodes

    // find 2 top nodes and connect
    void union(int i, int j){
        int pi = find(i);
        int pj = find(j);
        if(pj==0 || pi==0){
            parent[pi] = parent[pj] = sz[0] = 0;
        }else if(sz[pi] < sz[pj]){
            parent[pi] = pj;
            sz[pj]+=sz[pi];
        }else{
            parent[pj] = pi;
            sz[pi]+=sz[pj];
        }
    }

    // find the top node of the tree
    int find(int i){
        int p = i;
        while(p!=parent[p]) p=parent[p];
        return p;
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        parent = new int[n];
        sz = new int[n];

        Arrays.fill(sz, 1);
        for (int i = 0; i < n; i++) parent[i] = i;
        parent[firstPerson] = 0;

        Stream.of(meetings)
                .collect(Collectors.groupingBy(
                        m -> m[2], () -> new TreeMap<>(), Collectors.toList())) // group the meetings by time
                .forEach((i, list) -> {
                    Set<Integer> all = new HashSet<>(); // all person in this time slot
                    list.forEach(m -> {
                        union(m[0], m[1]);
                        all.add(m[0]); all.add(m[1]);
                    });
                    // reset person still don't know the secret (not the children of 0)
                    all.stream().filter(e -> find(e) != 0).forEach(e -> {
                        parent[e] = e;
                        sz[e] = 1;
                    });
                });

        // get all person know the secret (children of 0)
        return IntStream.range(0, n).filter(i -> find(i) == 0).boxed().collect(Collectors.toList());
    }
}
