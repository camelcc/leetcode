import javafx.util.Pair;

public class S0331VerifyPreorderSerializationBT {
    public boolean isValidSerialization(String preorder) {
        Pair<Boolean, String> res = consumeTree(preorder);
        return res.getKey() && res.getValue().isEmpty();
    }

    private Pair<Boolean, String> consumeTree(String preorder) {
        if (preorder.equals("#")) {
            return new Pair<>(true, "");
        }

        int i = preorder.indexOf(',');
        if (i == -1) {
            return new Pair<>(false, preorder);
        }
        String root = preorder.substring(0, i);
        if (root.equals("#")) {
            return new Pair<>(false, preorder);
        }

        String children = preorder.substring(i+1);
        i = children.indexOf(',');
        if (i == -1) {
            return new Pair<>(false, children);
        }
        String left = children.substring(0, i);
        String right;
        if (left.equals("#")) {
            right = children.substring(i+1);
        } else {
            Pair<Boolean, String> c = consumeTree(children);
            if (!c.getKey()) {
                return c;
            }

            right = c.getValue();
        }

        if (right.equals("#")) {
            return new Pair<>(true, "");
        }
        i = right.indexOf(',');
        if (i == -1) {
            return new Pair<>(false, children);
        }
        String r = right.substring(0, i);
        if (r.equals("#")) {
            return new Pair<>(true, right.substring(i+1));
        } else {
            return consumeTree(right);
        }
    }
}
