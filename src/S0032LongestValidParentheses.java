import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class S0032LongestValidParentheses {
    public int longestValidParentheses(String s) {
        List<int[]> pairs = new ArrayList<>();
        Stack<Integer> left = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left.push(i);
            } else { // )
                assert c == ')';
                if (left.isEmpty()) {
                    continue;
                }
                pairs.add(new int[]{left.pop(), i});
            }
        }

        pairs.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> top = new ArrayList<>();
        for (int[] pair : pairs) {
            if (!top.isEmpty() && top.get(top.size()-1)[1] > pair[1]) {
                continue;
            }

            top.add(pair);
        }
        if (top.isEmpty()) {
            return 0;
        }

        int[] current = top.get(0);
        int res = current[1]-current[0]+1;
        for (int i = 1; i < top.size(); i++) {
            int[] t = top.get(i);
            if (current[1] + 1 == t[0]) {
                current[1] = t[1];
            } else {
                res = Math.max(res, current[1]-current[0]+1);
                current = t;
            }
        }
        res = Math.max(res, current[1]-current[0]+1);
        return res;
    }
}
