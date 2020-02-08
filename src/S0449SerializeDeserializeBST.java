import util.TreeNode;

public class S0449SerializeDeserializeBST {
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "n";
            }

            String res = String.valueOf(root.val) + ",";

            String leftTree = serialize(root.left);
            assert !leftTree.isEmpty();
            int commaCount = 0;
            int commaIndex = -1;
            while (true) {
                commaIndex = leftTree.indexOf(",", commaIndex);
                if (commaIndex != -1) {
                    commaCount++;
                    commaIndex++;
                } else {
                    break;
                }
            }
            leftTree = String.valueOf(commaCount+1) + "," + leftTree;
            res = res + leftTree;

            String rightTree = serialize(root.right);
            res = res + "," + rightTree;
            return res;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            assert !data.isEmpty();
            if (data.equals("n")) {
                return null;
            }

            int split = data.indexOf(",");
            String rootStr = data.substring(0, split);
            assert !rootStr.isEmpty();
            TreeNode root = new TreeNode(Integer.valueOf(rootStr));
            String remainsStr = data.substring(split+1);

            split = remainsStr.indexOf(",");
            String leftCountStr = remainsStr.substring(0, split);
            assert !leftCountStr.isEmpty();
            int leftCount = Integer.valueOf(leftCountStr);
            assert leftCount > 0;
            remainsStr = remainsStr.substring(split+1);
            int leftTreeIndex = -1;
            while (leftCount > 0) {
                leftTreeIndex++;
                leftTreeIndex = remainsStr.indexOf(",", leftTreeIndex);
                leftCount--;
            }
            String leftTreeStr = remainsStr.substring(0, leftTreeIndex);
            root.left = deserialize(leftTreeStr);

            remainsStr = remainsStr.substring(leftTreeIndex+1);
            root.right = deserialize(remainsStr);

            return root;
        }
    }
}
