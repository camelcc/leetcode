import java.util.HashMap;
import java.util.Stack;
import java.util.TreeMap;

public class S1172DinnerPlateStacks {
    public static class DinnerPlates {
        HashMap<Integer, Stack<Integer>> stacks;
        TreeMap<Integer, Integer> occupy;
        int cap;
        int last;

        public DinnerPlates(int capacity) {
            stacks = new HashMap<>();
            occupy = new TreeMap<>();
            cap = capacity;
            last = -1;
        }

        public void push(int val) {
            Integer index = occupy.ceilingKey(0);
            if (index == null) {
                index = last+1;
            }

            stacks.putIfAbsent(index, new Stack<>());
            stacks.get(index).push(val);
            if (stacks.get(index).size() < cap) {
                occupy.put(index, stacks.get(index).size());
            } else {
                occupy.remove(index);
            }
            last = Math.max(last, index);
        }

        public int pop() {
            if (last == -1) {
                return -1;
            }
            assert !stacks.get(last).isEmpty();

            int res = stacks.get(last).pop();
            occupy.put(last, stacks.get(last).size());
            while (last >= 0 && occupy.getOrDefault(last, cap) == 0) {
                stacks.remove(last);
                occupy.remove(last);
                last--;
            }
            return res;
        }

        public int popAtStack(int index) {
            if (index > last) {
                return -1;
            } else if (index == last) {
                return pop();
            }
            if (occupy.containsKey(index) && occupy.get(index) == 0) {
                return -1;
            }

            int res = stacks.get(index).pop();
            occupy.put(index, stacks.get(index).size());
            return res;
        }
    }
}
