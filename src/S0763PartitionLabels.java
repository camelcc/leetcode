import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class S0763PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        Stack<Integer> partition = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (pos[c-'a'] == -1) {
                pos[c-'a'] = i;
                partition.push(1);
            } else {
                int last = i-partition.pop();
                while (last > pos[c-'a']) {
                    last -= partition.pop();
                }
                assert last >= 0;
                partition.push(i-last+1);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!partition.isEmpty()) {
            res.add(0, partition.pop());
        }
        return res;
    }
}
