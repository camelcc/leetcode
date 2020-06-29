import edu.princeton.cs.algs4.StdOut;
import util.Utils;

public class S0000Main {
    public static void main(String[] args) {
        S1494ParallelCoursesII s = new S1494ParallelCoursesII();
        StdOut.println(s.minNumberOfSemesters(4, Utils.str2array2d("[[2,1],[3,1],[1,4]]"), 2));
        StdOut.println(s.minNumberOfSemesters(5, Utils.str2array2d("[[2,1],[3,1],[4,1],[1,5]]"), 2));
        StdOut.println(s.minNumberOfSemesters(11, Utils.str2array2d("[]"), 2));
    }
}
