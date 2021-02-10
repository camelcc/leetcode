import util.TreeNode;

public class S1530NumberGoodLeafNodesPairs {
    public int countPairs(TreeNode root, int distance) {
        int[] res = count(root, distance);
        return res[distance+1];
    }

    private int[] count(TreeNode node, int distance) {
        int[] res = new int[distance + 2];
        if (node == null) {
            return res;
        }
        if (node.left == null && node.right == null) {
            res[0] = 1;
            return res;
        }
        int[] l = count(node.left, distance);
        int[] r = count(node.right, distance);
        int s = l[distance + 1] + r[distance + 1];
        for (int ld = 0; ld < distance-1; ld++) {
            for (int rd = 0; rd <= distance - 2 - ld; rd++) {
                s += l[ld] * r[rd];
            }
        }
        res[distance + 1] = s;
        for (int d = 1; d <= distance; d++) {
            res[d] = l[d-1] + r[d-1];
        }
        return res;
    }
}
