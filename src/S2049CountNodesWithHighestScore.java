import java.util.Arrays;

public class S2049CountNodesWithHighestScore {
    public int countHighestScoreNodes(int[] parents) {
        int[] cnt = new int[parents.length];
        int[][] children = new int[2][parents.length];
        Arrays.fill(children[0], -1);
        Arrays.fill(children[1], -1);
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] != -1) {
                if (children[0][parents[i]] == -1) {
                    children[0][parents[i]] = i;
                } else if (children[1][parents[i]] == -1) {
                    children[1][parents[i]] = i;
                }
            }
        }

        int total = cnt(children, cnt, 0);
        long score = 0;
        int res = 0;
        for (int i = 0; i < parents.length; i++) {
            long r = 0;
            int p = total-1;
            // remove node i
            if (children[0][i] != -1) {
                if (r == 0) {
                    r = cnt[children[0][i]];
                } else {
                    r = r*cnt[children[0][i]];
                }
                p -= cnt[children[0][i]];
            }
            if (children[1][i] != -1) {
                if (r == 0) {
                    r = cnt[children[1][i]];
                } else {
                    r = r*cnt[children[1][i]];
                }
                p -= cnt[children[1][i]];
            }
            if (parents[i] != -1) {
                if (r == 0) {
                    r = p;
                } else {
                    r = r*p;
                }
            }
            if (r > score) {
                score = r;
                res = 1;
            } else if (r == score) {
                res++;
            }
        }
        return res;
    }

    private int cnt(int[][] tree, int[] cnt, int v) {
        int res = 1;
        if (tree[0][v] != -1) {
            res += cnt(tree, cnt, tree[0][v]);
        }
        if (tree[1][v] != -1) {
            res += cnt(tree, cnt, tree[1][v]);
        }
        cnt[v] = res;
        return res;
    }
}
