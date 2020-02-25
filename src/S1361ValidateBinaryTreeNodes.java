import java.util.HashMap;
import java.util.HashSet;

public class S1361ValidateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashMap<Integer, Integer> parent = new HashMap<>();
        HashSet<Integer> roots = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                if (parent.containsKey(leftChild[i])) {
                    return false;
                }
                parent.put(leftChild[i], i);
                if (roots.contains(leftChild[i])) {
                    roots.remove(leftChild[i]);
                }
            }
            if (rightChild[i] != -1) {
                if (parent.containsKey(rightChild[i])) {
                    return false;
                }
                parent.put(rightChild[i], i);
                if (roots.contains(rightChild[i])) {
                    roots.remove(rightChild[i]);
                }
            }
            if (!parent.containsKey(i)) {
                roots.add(i);
            }
        }
        return roots.size() == 1;
    }
}
