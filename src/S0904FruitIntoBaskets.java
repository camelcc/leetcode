public class S0904FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        int start = -1, end = 0, pre = -1, current = tree[0];
        int res = 0;
        for (int i = 1; i < tree.length; i++, end++) {
            if (tree[i] == current) {
                continue;
            } else if (tree[i] == pre) {
                int t = pre;
                pre = current;
                current = t;
            } else {
                res = Math.max(res, end-start);

                start = end;
                while (start >= 0 && tree[start] == current) {
                    start--;
                }
                pre = current;
                current = tree[i];
            }
        }
        res = Math.max(res, end-start);
        return res;
    }
}
