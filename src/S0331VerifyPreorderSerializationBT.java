public class S0331VerifyPreorderSerializationBT {
    public boolean isValidSerialization(String preorder) {
        String[] res = consumeTree(preorder);
        return Boolean.parseBoolean(res[0]) && res[1].isEmpty();
    }

    private String[] consumeTree(String preorder) {
        if (preorder.equals("#")) {
            return new String[]{String.valueOf(true), ""};
        }

        int i = preorder.indexOf(',');
        if (i == -1) {
            return new String[]{String.valueOf(false), preorder};
        }
        String root = preorder.substring(0, i);
        if (root.equals("#")) {
            return new String[]{String.valueOf(false), preorder};
        }

        String children = preorder.substring(i+1);
        i = children.indexOf(',');
        if (i == -1) {
            return new String[]{String.valueOf(false), children};
        }
        String left = children.substring(0, i);
        String right;
        if (left.equals("#")) {
            right = children.substring(i+1);
        } else {
            String[] c = consumeTree(children);
            if (!Boolean.parseBoolean(c[0])) {
                return c;
            }

            right = c[1];
        }

        if (right.equals("#")) {
            return new String[]{String.valueOf(true), ""};
        }
        i = right.indexOf(',');
        if (i == -1) {
            return new String[]{String.valueOf(false), children};
        }
        String r = right.substring(0, i);
        if (r.equals("#")) {
            return new String[]{String.valueOf(true), right.substring(i+1)};
        } else {
            return consumeTree(right);
        }
    }
}
