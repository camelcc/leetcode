import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

// https://leetcode.com/problems/booking-concert-tickets-in-groups/discuss/2084924/Segment-Tree-Java-solution-with-comments
public class S2286BookingConcertTicketsGroups {
    static class BookMyShow {
        static class SegTree {
            int N, M;
            long[] sum;
            long[] tree;

            SegTree(int n, int m) {
                N = n;
                M = m;

                sum = new long[4*n];
                tree = new long[4*n];
                build(0, 0, N-1, M);
            }

            private void build(int i, int lo, int hi, long val) {
                if (lo == hi) {
                    tree[i] = val;
                    sum[i] = val;
                    return;
                }

                int mid = lo + (hi-lo)/2;
                build(2*i+1, lo, mid, val);
                build(2*i+2, mid+1, hi, val);
                tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
                sum[i] = sum[2*i+1]+sum[2*i+2];
            }

            private void update(int i, int lo, int hi, int pos, int val) {
                if (lo == hi) {
                    tree[i] = val;
                    sum[i] = val;
                    return;
                }

                int mid = lo + (hi-lo)/2;
                if (pos <= mid) {
                    update(2*i+1, lo, mid, pos, val);
                } else {
                    update(2*i+2, mid+1, hi, pos, val);
                }
                tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
                sum[i] = sum[2*i+1]+sum[2*i+2];
            }

            public void update(int pos, int val) {
                update(0, 0, N-1, pos, val);
            }

            public int gatherQuery(int k, int maxRow) {
                return gatherQuery(0, 0, N-1, k, maxRow);
            }

            private int gatherQuery(int i, int lo, int hi, int k, int maxRow) {
                if (tree[i] < k || lo > maxRow) {
                    return -1;
                }
                if (lo == hi) {
                    return lo;
                }
                int mid = lo + (hi-lo)/2;
                int c = gatherQuery(2*i+1, lo, mid, k, maxRow);
                if (c == -1) {
                    c = gatherQuery(2*i+2, mid+1, hi, k, maxRow);
                }
                return c;
            }

            public long sumQuery(int l, int r) {
                return sumQuery(0, 0, N-1, l, r);
            }

            private long sumQuery(int i, int lo, int hi, int l, int r) {
                if (lo > r || hi < l) { return 0; }
                if (lo >= l && hi <= r) { return sum[i]; }
                int mid = lo + (hi-lo)/2;
                return sumQuery(2*i+1, lo, mid, l, r) + sumQuery(2*i+2, mid+1, hi, l, r);
            }
        }

        SegTree segTree;
        int[] rows;

        public BookMyShow(int n, int m) {
            segTree = new SegTree(n, m);
            rows = new int[n];
            Arrays.fill(rows, m);
        }

        public int[] gather(int k, int maxRow) {
            int row = segTree.gatherQuery(k, maxRow); // find row which has k seats
            if(row == -1) return new int[0];
            int col = segTree.M - rows[row]; // find column in the row which has k seats
            rows[row] -= k; // reduce the seats
            segTree.update(row, rows[row]); // update the segment tree
            return new int[]{row, col};
        }

        public boolean scatter(int k, int maxRow) {
            long sum = segTree.sumQuery(0, maxRow); // find the sum for the given range [0, maxRow]
            if(sum < k) return false; // can't find k seats in [0, maxRow]

            for(int i=0; i<=maxRow && k !=0 ; i++){
                if(rows[i] > 0){                       // if current row has seats then allocate those seats
                    long t = Math.min(rows[i], k);
                    rows[i] -= t;
                    k -= t;
                    segTree.update(i, rows[i]);  // update the segment tree
                }
            }
            return true;
        }
    }
}
