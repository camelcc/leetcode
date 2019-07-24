import java.util.ArrayList;
import java.util.List;

public class S1104PathInZigzagLabelledBinaryTree {
    public List<Integer> pathInZigZagTree(int label) {
        int depth = 0;
        while (label >= (0x1<<(depth+1))) {
            depth++;
        }
        int v = label;
        if (depth%2 != 0) {
            v = (0x1<<depth) + ((0x1<<(depth+1)) - 1 - label);
        }
        List<Integer> res = new ArrayList<>();
        res.add(label);
        v = v/2;
        while (v >= 1) {
            depth--;
            if (depth%2 == 0) {
                res.add(0, v);
            } else {
                res.add(0, (0x1<<(depth+1))-1-(v-(0x1<<depth)));
            }
            v = v/2;
        }
        return res;
    }
}
