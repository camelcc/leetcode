import java.util.LinkedList;

public class S0933NumberRecentCalls {
    class RecentCounter {
        LinkedList<Integer> times;

        public RecentCounter() {
            times = new LinkedList<>();
        }

        public int ping(int t) {
            times.offer(t);
            int start = t-3000;
            while (!times.isEmpty() && times.peek() < start) {
                times.poll();
            }
            return times.size();
        }
    }
}
