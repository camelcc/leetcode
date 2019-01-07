import java.util.List;
import java.util.Stack;

public class S0636ExclusiveTimeFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];

        Stack<int[]> timeline = new Stack<>();
        Stack<Integer> occupied = new Stack<>();
        int occupy = 0;
        for (String log : logs) {
            String[] t = log.split(":");
            int id = Integer.valueOf(t[0]);
            boolean start = t[1].equals("start");
            int time = Integer.valueOf(t[2]);

            if (start) {
                timeline.push(new int[]{id, time});
                occupied.push(occupy);
                occupy = 0;
            } else {
                assert !timeline.isEmpty();
                int[] l = timeline.pop();
                assert l[0] == id;
                int d = time-l[1]+1;
                res[id] += d-occupy;
                occupy = occupied.pop() + d;
            }
        }
        return res;
    }
}
