import java.util.*;

public class S1418DisplayTableFoodOrdersRestaurant {
    public List<List<String>> displayTable(List<List<String>> orders) {

        HashSet<Integer> tables = new HashSet<>();
        HashSet<String> foods = new HashSet<>();
        HashMap<String, HashMap<String, Integer>> cnt = new HashMap<>();
        for (List<String> order : orders) {
            String table = order.get(1);
            tables.add(Integer.parseInt(table));
            String food = order.get(2);
            foods.add(food);
            cnt.putIfAbsent(table, new HashMap<>());
            HashMap<String, Integer> t = cnt.get(table);
            t.put(food, t.getOrDefault(food, 0)+1);
        }

        ArrayList<String> fs = new ArrayList<>(foods);
        Collections.sort(fs);
        ArrayList<Integer> ts = new ArrayList<>(tables);
        Collections.sort(ts);

        List<List<String>> res = new ArrayList<>();

        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(fs);
        res.add(header);

        for (int t : ts) {
            List<String> tt = new ArrayList<>();
            tt.add(String.valueOf(t));
            HashMap<String, Integer> tableOrder = cnt.get(String.valueOf(t));
            for (String f : fs) {
                tt.add(String.valueOf(tableOrder.getOrDefault(f, 0)));
            }
            res.add(tt);
        }
        return res;
    }
}
