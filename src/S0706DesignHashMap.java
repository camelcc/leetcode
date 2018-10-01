import java.util.ArrayList;
import java.util.List;

public class S0706DesignHashMap {
    class MyHashMap {
        private List<Integer>[] keys;
        private List<Integer>[] values;
        private int M;

        /** Initialize your data structure here. */
        public MyHashMap() {
            M = 10000;
            keys = new List[M];
            values = new List[M];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            if (keys[key%M] == null) {
                keys[key%M] = new ArrayList<>();
                values[key%M] = new ArrayList<>();
            }
            int index = keys[key%M].indexOf(key);
            if (index == -1) {
                keys[key%M].add(key);
                values[key%M].add(value);
            } else {
                values[key%M].set(index, value);
            }
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            if (keys[key%M] == null) {
                return -1;
            }
            int index = keys[key%M].indexOf(key);
            if (index == -1) {
                return -1;
            } else {
                return values[key%M].get(index);
            }
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            if (keys[key%M] == null) {
                return;
            }
            int index = keys[key%M].indexOf(key);
            if (index == -1) {
                return;
            }

            keys[key%M].remove(index);
            values[key%M].remove(index);
        }
    }
}
