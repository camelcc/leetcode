import util.TreeNode;

public class S0297SerializeDeserializeBinaryTree {
    public static class Codec {
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            return String.valueOf(root.val) + "L" + serialize(root.left) + "R" + serialize(root.right);
        }

        public TreeNode deserialize(String data) {
            return de(new StringBuilder(data));
        }

        private TreeNode de(StringBuilder sb) {
            if (sb.length() == 0) {
                return null;
            }

            int l = sb.indexOf("L");
            int r = sb.indexOf("R");
            assert l >= 0 && r > l;
            TreeNode res = new TreeNode(Integer.valueOf(sb.substring(0, l)));
            sb.delete(0, l+1);
            if (l+1 == r) {
                res.left = null;
            } else {
                res.left = de(sb);
            }
            assert sb.charAt(0) == 'R';
            sb.deleteCharAt(0);
            if (sb.length() == 0 || sb.charAt(0) == 'R') {
                res.right = null;
            } else {
                res.right = de(sb);
            }
            return res;
        }
    }
}
