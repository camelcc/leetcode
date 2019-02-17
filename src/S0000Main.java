import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S0000Main {
    public static void main(String[] args) {
        S0756PyramidTransitionMatrix matrix = new S0756PyramidTransitionMatrix();
        List<String> allowed = new ArrayList<>();
        Collections.addAll(allowed, "CBB","ACB","ABD","CDB","BDC","CBC","DBA","DBB","CAB","BCB","BCC","BAA","CCD","BDD","DDD","CCA","CAA","CCC","CCB");
        StdOut.println(matrix.pyramidTransition("CCC", allowed));
    }
}
