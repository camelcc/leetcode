import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0000Main {
    public static void main(String[] args) {
        S0554BrickWall wall = new S0554BrickWall();
        List<List<Integer>> w = new ArrayList<>();
        w.add(Arrays.asList(1,2,2,1));
        w.add(Arrays.asList(3,1,2));
        w.add(Arrays.asList(1,3,2));
        w.add(Arrays.asList(2,4));
        w.add(Arrays.asList(3,1,2));
        w.add(Arrays.asList(1,3,1,1));
        StdOut.println(wall.leastBricks(w));
    }
}
