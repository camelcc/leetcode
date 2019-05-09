import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0352DataStreamDisjointIntervals.SummaryRanges intervals = new S0352DataStreamDisjointIntervals.SummaryRanges();
        intervals.addNum(1);
        intervals.getIntervals();
        intervals.addNum(3);
        intervals.getIntervals();
        intervals.addNum(7);
        intervals.getIntervals();
        intervals.addNum(2);
        intervals.getIntervals();
        intervals.addNum(6);
        intervals.getIntervals();
    }
}
