import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S0385MiniParser {
    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public class NestedInteger {
        private List<NestedInteger> list;
        private int val;

        // Constructor initializes an empty nested list.
        public NestedInteger() {
            list = new ArrayList<>();
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            val = value;
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return list == null;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return  val;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            val = value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            list.add(ni);
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return isInteger() ? null : list;
        }
    }

    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> parsed = new Stack<>();

        List<NestedInteger> nums = new ArrayList<>();
        int startIndex = 0;
        while (startIndex < s.length()) {
            char c = s.charAt(startIndex);
            if (c == ',') {
                startIndex++;
            } else if (c == '[') {
                if (!nums.isEmpty()) {
                    assert !parsed.isEmpty();
                    NestedInteger p = parsed.pop();
                    p.getList().addAll(nums);
                    parsed.push(p);
                }

                NestedInteger list = new NestedInteger();
                parsed.push(list);
                nums.clear();
                startIndex++;
            } else if (c == ']') {
                assert !parsed.isEmpty();
                NestedInteger list = parsed.pop();
                assert !list.isInteger();
                list.getList().addAll(nums);
                nums.clear();
                nums.add(list);

                startIndex++;
            } else {
                startIndex = readInteger(s, startIndex, nums);
            }
        }

        if (!nums.isEmpty()) {
            assert nums.size() == 1;
            parsed.push(nums.get(0));
        }
        assert parsed.size() == 1;
        return parsed.pop();
    }

    private int readInteger(String s, int startIndex, List<NestedInteger> nums) {
        int endIndex = startIndex;
        String n = null;
        int open = s.indexOf('[', startIndex);
        int close = s.indexOf(']', startIndex);
        if (open == -1 && close == -1) {
            n = s.substring(startIndex);
            endIndex = s.length();
        } else if (open == -1) {
            n = s.substring(startIndex, close);
            endIndex = close;
        } else if (close == -1) {
            n = s.substring(startIndex, open);
            endIndex = open;
        } else {
            endIndex = Math.min(open, close);
            n = s.substring(startIndex, endIndex);
        }
        String[] ns = n.split(",");
        for (String t : ns) {
            if (t.isEmpty()) {
                continue;
            }
            nums.add(new NestedInteger(Integer.valueOf(t)));
        }
        return endIndex;
    }
}
