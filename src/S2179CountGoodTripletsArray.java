// https://leetcode.com/problems/count-good-triplets-in-an-array/discuss/1784036/Java-Solution-Using-Fenwick-Tree
public class S2179CountGoodTripletsArray {
    class FenwickTree {
        int[] sum;
        public FenwickTree(int N) {
            sum = new int[N+2];
        }

        void update(int p, int diff) {
            p++;
            while (p < sum.length) {
                sum[p] += diff;
                p += lowerBit(p);
            }
        }

        int query(int i) {
            int res = 0;
            i++;
            while (i > 0) {
                res += sum[i];
                i -= lowerBit(i);
            }
            return res;
        }

        private int lowerBit(int x) {
            return x & (-x);
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int N = nums1.length;
        int[] pos = new int[N];
        for (int i = 0; i < N; i++) {
            pos[nums2[i]] = i;
        }
        FenwickTree ft = new FenwickTree(N+1);
        long[] left = new long[N];
        for (int i = 0; i < N; i++) {
            int idx = pos[nums1[i]];
            left[i] = ft.query(idx-1);
            ft.update(idx,1);
        }

        long[] right = new long[N];
        ft = new FenwickTree(N+1);
        for(int i= N-1; i >= 0; i--) {
            int idx = pos[nums1[i]];
            right[i]= ft.query(N+1) - ft.query(idx);
            ft.update(idx,1);
        }

        long ans=0;

        for (int i=0; i < N; i++)
            ans+= left[i]*right[i];

        return ans;
    }
}
