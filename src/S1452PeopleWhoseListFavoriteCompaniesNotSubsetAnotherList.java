import java.util.*;

public class S1452PeopleWhoseListFavoriteCompaniesNotSubsetAnotherList {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        LinkedList<Integer> res = new LinkedList<>();

        int index = 1;
        HashMap<String, Integer> map = new HashMap<>();
        List<int[]> favorites = new ArrayList<>();
        for (List<String> f : favoriteCompanies) {
            int[] t = new int[f.size()];
            for (int i = 0; i < f.size(); i++) {
                String c = f.get(i);
                if (map.containsKey(c)) {
                    t[i] = map.get(c);
                } else {
                    map.put(c, index);
                    t[i] = index;
                    index++;
                }
            }
            Arrays.sort(t);
            favorites.add(t);
        }

        for (int i = 0; i < favorites.size(); i++) {
            LinkedList<Integer> next = new LinkedList<>();

            boolean contained = false;
            boolean newSuperSet = false;
            while (!res.isEmpty()) {
                int s = res.poll();

                int t = contains(favorites.get(s), favorites.get(i));
                if (t == 0) {
                    next.offer(s);
                } else if (t == 1) { // s contains i
                    contained = true;
                    next.offer(s);
                    break;
                } else if (t == 2) { // i contains s
                    newSuperSet = true;
                    break;
                }
            }
            if (!contained && !newSuperSet) {
                next.offer(i);
            } else if (contained) {
                while (!res.isEmpty()) {
                    next.offer(res.poll());
                }
            } else if (newSuperSet) {
                while (!res.isEmpty()) {
                    next.offer(res.poll());
                }

                LinkedList<Integer> n = new LinkedList<>();
                n.offer(i);
                while (!next.isEmpty()) {
                    int o = next.poll();
                    if (contains(favorites.get(i), favorites.get(o)) == 0) {
                        n.offer(o);
                    }
                }
                Collections.sort(n);
                next = n;
            }
            res = next;
        }

        return res;
    }

    // 0 - different, 1 - super contains current, 2 - current contains super
    private int contains(int[] superSets, int[] current) {
        int si = 0, ci = 0, sk = 0, ck = 0;
        while (si < superSets.length && ci < current.length && (sk == 0 || ck == 0)) {
            int sv = superSets[si];
            int cv = current[ci];
            if (sv == cv) {
                si++;
                ci++;
            } else if (sv > cv) {
                ck++;
                ci++;
            } else if (sv < cv) {
                sk++;
                si++;
            }
        }
        if (sk > 0 && ck > 0) {
            return 0;
        } else if (sk > 0) {
            // si == super.len || ci == current.len
            if (ci == current.length) {
                return 1;
            } else {
                return 0;
            }
        } else if (ck > 0) {
            // si == super.len || ci == current.len
            if (si == superSets.length) {
                return 2;
            } else {
                return 0;
            }
        } else { // sk == 0 && ck == 0
            // si == super.len || ci == current.len
            if (si == superSets.length) {
                return 2;
            } else {
                return 1;
            }
        }
    }
}
