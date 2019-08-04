import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S1145BinaryTreeColoringGame.TreeNode root = new S1145BinaryTreeColoringGame.TreeNode(1);
        root.left = new S1145BinaryTreeColoringGame.TreeNode(2);
        root.right = new S1145BinaryTreeColoringGame.TreeNode(3);
        root.left.left = new S1145BinaryTreeColoringGame.TreeNode(4);
        root.left.right = new S1145BinaryTreeColoringGame.TreeNode(5);
        S1145BinaryTreeColoringGame game = new S1145BinaryTreeColoringGame();
        StdOut.print(game.btreeGameWinningMove(root, 5, 1));
    }
}
