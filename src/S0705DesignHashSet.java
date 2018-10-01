import java.util.ArrayList;
import java.util.List;

public class S0705DesignHashSet {
    class MyHashSet {
        private List<Integer>[] data;
        private int M;

        /** Initialize your data structure here. */
        public MyHashSet() {
            M = 10000;
            data = new List[M];
        }

        public void add(int key) {
            if (contains(key)) {
                return;
            }
            if (data[key%M] == null) {
                data[key%M] = new ArrayList<>();
            }
            data[key%M].add(key);
        }

        public void remove(int key) {
            if (data[key%M] != null) {
                data[key%M].remove((Integer)key);
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return data[key%M] != null && data[key%M].contains(key);
        }
    }
}
