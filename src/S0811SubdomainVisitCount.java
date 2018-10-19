import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S0811SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> cnt = new HashMap<>();
        for (String cpd : cpdomains) {
            String[] t = cpd.split(" ");
            int c = Integer.valueOf(t[0]);
            String d = t[1];

            int start = 0;
            while (start < d.length() && d.indexOf(".", start) != -1) {
                String sub = d.substring(start);
                cnt.put(sub, cnt.getOrDefault(sub, 0) + c);
                start = d.indexOf(".", start)+1;
            }
            if (start < d.length()) {
                String sub = d.substring(start);
                cnt.put(sub, cnt.getOrDefault(sub, 0) + c);
            }
        }
        List<String> res = new ArrayList<>();
        for (String key : cnt.keySet()) {
            res.add(String.valueOf(cnt.get(key)) + " " + key);
        }
        return res;
    }
}
