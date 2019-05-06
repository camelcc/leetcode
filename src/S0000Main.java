import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0297SerializeDeserializeBinaryTree.TreeNode root = new S0297SerializeDeserializeBinaryTree.TreeNode(1);
        root.left = new S0297SerializeDeserializeBinaryTree.TreeNode(2);
        root.right = new S0297SerializeDeserializeBinaryTree.TreeNode(3);
        root.right.left = new S0297SerializeDeserializeBinaryTree.TreeNode(4);
        root.right.right = new S0297SerializeDeserializeBinaryTree.TreeNode(5);
        S0297SerializeDeserializeBinaryTree.Codec codec = new S0297SerializeDeserializeBinaryTree.Codec();
        String s = codec.serialize(root);
        StdOut.println(s);
        S0297SerializeDeserializeBinaryTree.TreeNode b = codec.deserialize(s);
    }
}
