import java.util.*;

public class S069TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> cnt = new HashMap<>();
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int d = cnt.get(o2) - cnt.get(o1);
                if (d != 0) {
                    return d;
                }

                return o1.compareTo(o2);
            }
        };

        List<String> res = new ArrayList<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0)+1);
            res.remove(word);
            int pos = Collections.binarySearch(res, word, comp);
            assert pos < 0;
            pos = -(pos + 1);
            if (pos >= k) {
                continue;
            } else {
                res.add(pos, word);
                if (res.size() > k) {
                    res.remove(res.size() - 1);
                }
            }
        }
        return res;
    }
}
