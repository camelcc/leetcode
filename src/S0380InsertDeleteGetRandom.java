import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class S0380InsertDeleteGetRandom {
    class RandomizedSet {
        private List<Integer> data;
        private HashMap<Integer, Integer> pos;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            data = new ArrayList<>();
            pos = new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (pos.containsKey(val)) {
                return false;
            }
            pos.put(val, data.size());
            data.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!pos.containsKey(val)) {
                return false;
            }

            int p = pos.get(val);
            pos.remove(val);
            // move pos from hash table
            for (int i = p+1; i < data.size(); i++) {
                pos.put(data.get(i), i-1);
            }
            data.remove(p);
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
