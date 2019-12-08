import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S1282GroupPeopleGivenGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> group = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            // ith people
            int gs = groupSizes[i];
            group.putIfAbsent(gs, new ArrayList<>());
            group.get(gs).add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int key : group.keySet()) {
            List<Integer> g = group.get(key);
            assert g.size() > 0 && g.size()%key == 0;
            int i = 0;
            while (i < g.size()) {
                List<Integer> rg = new ArrayList<>();
                for (int t = 0; t < key; t++) {
                    rg.add(g.get(i));
                    i++;
                }
                res.add(rg);
            }
        }
        return res;
    }
}
