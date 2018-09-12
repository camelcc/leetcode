import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0207CourseSchedule schedule = new S0207CourseSchedule();
        StdOut.println(schedule.canFinish(2, new int[][] {{1, 0}, {0, 1}}));
    }
}
