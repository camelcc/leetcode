import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0460LFUCache.LFUCache lfu = new S0460LFUCache.LFUCache(2);
        lfu.put(1, 1);
        lfu.put(2, 2);
        StdOut.println(lfu.get(1));
        lfu.put(3, 3);
        StdOut.println(lfu.get(2));
        StdOut.println(lfu.get(3));
        lfu.put(4, 4);
        StdOut.println(lfu.get(1));
        StdOut.println(lfu.get(3));
        StdOut.println(lfu.get(4));
    }
}
