import java.util.ArrayList;
import java.util.List;

public class S1656DesignOrderedStream {
    class OrderedStream {
        String[] data;
        int current;

        public OrderedStream(int n) {
            data = new String[n+1];
            current = 1;
        }

        public List<String> insert(int idKey, String value) {
            data[idKey] = value;
            List<String> res = new ArrayList<>();
            int i = current;
            while (i < data.length && data[i] != null) {
                res.add(data[i]);
                i++;
            }
            current = i;
            return res;
        }
    }
}
