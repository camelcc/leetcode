import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S0630CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt((int[] o) -> o[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int total = 0;
        for (int[] course : courses) {
            total += course[0];
            queue.add(course[0]);
            if (total > course[1]) {
                total -= queue.poll();
            }
        }
        return queue.size();
    }
}
