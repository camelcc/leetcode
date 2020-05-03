import java.util.HashMap;
import java.util.List;

public class S1436DestinationCity {
    public String destCity(List<List<String>> paths) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }
        String res = paths.get(0).get(1);
        while (map.containsKey(res)) {
            res = map.get(res);
        }
        return res;
    }
}
