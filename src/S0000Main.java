public class S0000Main {
    public static void main(String[] args) {
        S0146LRUCache.LRUCache cache = new S0146LRUCache.LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);

        cache.get(1);
        cache.get(2);
    }
}
