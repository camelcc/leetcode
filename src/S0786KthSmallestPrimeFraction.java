import java.util.PriorityQueue;

public class S0786KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2) -> A[o1[0]]*A[o2[1]]-A[o2[0]]*A[o1[1]]);
        for (int i = 0; i < A.length-1; i++) {
            pq.add(new int[]{i, A.length-1});
        }

        int cnt = 1;
        while (cnt < K) {
            int[] t = pq.poll();
            if (t[1]-1 > t[0]) {
                pq.add(new int[]{t[0], t[1]-1});
            }
            cnt++;
        }
        int[] r = pq.poll();
        return new int[]{A[r[0]], A[r[1]]};
    }
}
