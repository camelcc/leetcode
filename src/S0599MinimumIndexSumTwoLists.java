import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S0599MinimumIndexSumTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> index1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            index1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            String l = list2[i];
            if (!index1.containsKey(l)) {
                continue;
            }

            int p = index1.get(l);
            if (min > i + p) {
                min = i + p;
                res.clear();
                res.add(l);
            } else if (min == (i + p)) {
                res.add(l);
            }
        }

        return res.toArray(new String[res.size()]);
    }
}
