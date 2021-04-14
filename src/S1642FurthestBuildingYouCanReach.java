import java.util.PriorityQueue;

public class S1642FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        while (res < heights.length-1) {
            int h = heights[res+1] - heights[res];
            if (h <= 0) {
                res++;
                continue;
            }

            if (ladders > 0) {
                pq.offer(h);
                ladders--;
                res++;
                continue;
            }
            if (!pq.isEmpty() && pq.peek() < h) {
                pq.offer(h);
                h = pq.poll();
            }
            if (bricks < h) {
                break;
            } else {
                bricks -= h;
            }
            res++;
        }
        return res;
    }
}
