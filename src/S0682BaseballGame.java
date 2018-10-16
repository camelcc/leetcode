import java.util.Stack;

public class S0682BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> vals = new Stack<>();
        int sum = 0;

        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            if (op.equals("+")) {
                int v1 = vals.pop();
                int v2 = vals.pop();
                vals.push(v2);
                vals.push(v1);
                int s = v1+v2;
                sum += s;
                vals.push(s);
            } else if (op.equals("D")) {
                int d = vals.peek()*2;
                sum += d;
                vals.push(d);
            } else if (op.equals("C")) {
                int c = vals.pop();
                sum -= c;
            } else {
                int v = Integer.valueOf(op);
                vals.push(v);
                sum += v;
            }
        }
        return sum;
    }
}
