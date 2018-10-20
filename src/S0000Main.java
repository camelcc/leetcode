import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0874WalkingRobotSimulation robot = new S0874WalkingRobotSimulation();
        StdOut.println(robot.robotSim(new int[] {4,-1,4,-2,4}, new int[][]{{2,4}}));
    }
}
