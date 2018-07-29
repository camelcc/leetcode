import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0215KthElement element = new S0215KthElement();
        StdOut.println(element.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
