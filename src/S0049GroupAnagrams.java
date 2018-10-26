import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class S0049GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            List<String> list = res.getOrDefault(sorted, new ArrayList<>());
            list.add(str);
            res.put(sorted, list);
        }

        return new ArrayList<>(res.values());
    }
}
