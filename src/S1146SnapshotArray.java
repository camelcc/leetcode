import java.util.TreeMap;

public class S1146SnapshotArray {
    class SnapshotArray {
        private int snapId;
        private TreeMap<Integer, Integer>[] array;

        public SnapshotArray(int length) {
            snapId = 0;
            array = new TreeMap[length];
        }

        public void set(int index, int val) {
            if (array[index] == null) {
                array[index] = new TreeMap<>();
            }
            array[index].put(snapId, val);
        }

        public int snap() {
            int res = snapId;
            snapId++;
            return res;
        }

        public int get(int index, int snap_id) {
            if (array[index] == null) {
                return 0;
            }
            Integer low = array[index].floorKey(snap_id);
            if (low == null) {
                return 0;
            }
            return array[index].get(low);
        }
    }
}
