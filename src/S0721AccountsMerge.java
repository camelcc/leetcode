import java.util.*;

public class S0721AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts.isEmpty()) {
            return new ArrayList<>();
        }

        List<HashSet<String>> emails = new ArrayList<>();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            String name = accounts.get(i).get(0);
            names.add(name);
            List<String> es = new ArrayList<>(accounts.get(i));
            es.remove(0);
            emails.add(new HashSet<>(es));

            List<Integer> merged = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (!Collections.disjoint(emails.get(j), es)) {
                    merged.add(j);
                }
            }
            merged.add(i);

            HashSet<String> host = emails.get(merged.get(0));
            for (int j = 1; j < merged.size(); j++) {
                host.addAll(emails.get(merged.get(j)));
                emails.get(merged.get(j)).clear();
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            List<String> es = new ArrayList<>(emails.get(i));
            if (es.isEmpty()) {
                continue;
            }
            es.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            es.add(0, names.get(i));
            res.add(es);
        }
        return res;
    }
}
