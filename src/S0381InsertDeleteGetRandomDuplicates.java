import java.util.*;

public class S0381InsertDeleteGetRandomDuplicates {
    class RandomizedCollection {
        private List<Integer> data;
        private HashMap<Integer, HashSet<Integer>> pos;

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            data = new ArrayList<>();
            pos = new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            boolean res = true;
            if (!pos.containsKey(val)) {
                pos.put(val, new HashSet<>());
            } else {
                res = false;
            }
            HashSet<Integer> locs = pos.get(val);
            locs.add(data.size());
            data.add(val);
            return res;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!pos.containsKey(val)) {
                return false;
            }

            HashSet<Integer> locs = pos.get(val);
            assert !locs.isEmpty();
            int first = locs.iterator().next();
            locs.remove(first);
            // swap first & last
            if (first != data.size()-1) {
                int t = data.get(data.size()-1);
                pos.get(t).remove(data.size()-1);
                pos.get(t).add(first);
                data.set(first, t);
            }

            data.remove(data.size()-1);
            if (pos.get(val).isEmpty()) {
                pos.remove(val);
            }
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            if (data.size() == 0) {
                return 0;
            }
            return data.get(new Random().nextInt(data.size()));
        }
    }
}
