import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class S1203SortItemsGroupsRespectingDependencies {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for(int i = 0; i < group.length; i++)
            if(group[i] == -1)
                group[i] = m++; // assign none-group elements a group

        int[] inDI = new int[n];
        int[] inDG = new int[m];
        List<Integer>[] groupEdges = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            groupEdges[i] = new ArrayList<>();
        }
        List<Integer>[] itemEdges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            itemEdges[i] = new ArrayList<>();
        }
        List<Integer>[] groups = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            groups[i] = new ArrayList<>();
        }

        for (int i = 0; i < group.length; i++) {
            groups[group[i]].add(i);
        }
        for (int i = 0; i < beforeItems.size(); i++) {
            int currentGroup = group[i];
            List<Integer> before = beforeItems.get(i);
            for (int b : before) {
                int beforeGroup = group[b];
                if (currentGroup == beforeGroup) {
                    inDI[i]++;
                    itemEdges[b].add(i);
                } else {
                    inDG[currentGroup]++;
                    groupEdges[beforeGroup].add(currentGroup);
                }
            }
        }

        List<List<Integer>> order = new ArrayList<>();

        // sort on group
        PriorityQueue<Integer> groupPQ = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            if (inDG[i] == 0) {
                groupPQ.offer(i);
            }
        }
        while (!groupPQ.isEmpty()) {
            int g = groupPQ.poll();

            ArrayList<Integer> items = new ArrayList<>();
            PriorityQueue<Integer> itemPQ = new PriorityQueue<>();
            for (int i : groups[g]) {
                if (inDI[i] == 0) {
                    itemPQ.offer(i);
                }
            }
            while (!itemPQ.isEmpty()) {
                int ti = itemPQ.poll();
                items.add(ti);

                for (int t : itemEdges[ti]) {
                    inDI[t]--;
                    if (inDI[t] == 0) {
                        itemPQ.offer(t);
                    }
                }
            }

            if (items.size() != groups[g].size()) {
                return new int[]{};
            }

            order.add(items);

            for (int t : groupEdges[g]) {
                inDG[t]--;
                if (inDG[t] == 0) {
                    groupPQ.offer(t);
                }
            }
        }
        if (order.size() != m) {
            return new int[]{};
        }

        int[] res = new int[n];
        int index = 0;
        for (List<Integer> o : order) {
            for (int t : o) {
                res[index++] = t;
            }
        }
        return res;
    }
}
