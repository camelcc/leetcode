import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S0609FindDuplicateFileSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> groups = new HashMap<>();
        for (String path : paths) {
            String[] t = path.split(" ");
            if (t.length <= 1) {
                continue;
            }

            String prefix = t[0];
            for (int i = 1; i < t.length; i++) {
                String file = t[i];
                int index = file.indexOf('(');
                if (index <= 0 || index >= file.length()-1) {
                    continue;
                }

                String filename = prefix + "/" + file.substring(0, index);
                String content = file.substring(index+1, file.length()-1);
                if (!groups.containsKey(content)) {
                    groups.put(content, new ArrayList<>());
                }
                groups.get(content).add(filename);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> v : groups.values()) {
            if (v.size() > 1) {
                res.add(v);
            }
        }
        return res;
    }
}
