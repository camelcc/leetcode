import java.util.TreeMap;

public class S0975OddEvenJump {
    public int oddEvenJumps(int[] A) {
        boolean[] odd = new boolean[A.length];
        odd[A.length-1] = true;
        boolean[] even = new boolean[A.length];
        even[A.length-1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[A.length-1], A.length-1);
        for (int i = A.length-2; i >= 0; i--) {
            // odd
            if (map.ceilingKey(A[i]) != null) {
                odd[i] = even[map.get(map.ceilingKey(A[i]))];
            }
            // even
            if (map.floorKey(A[i]) != null) {
                even[i] = odd[map.get(map.floorKey(A[i]))];
            }
            map.put(A[i], i);
        }
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (odd[i]) {
                res++;
            }
        }
        return res;
    }
}
