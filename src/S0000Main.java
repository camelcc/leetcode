import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0752OpenLock lock = new S0752OpenLock();
        StdOut.println(lock.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
    }
}
