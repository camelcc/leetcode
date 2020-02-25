public class S1362ClosestDivisors {
    public int[] closestDivisors(int num) {
        int[] res = new int[]{1, num+1};
        int diff = num;
        for (int v : new int[]{num + 1, num + 2}) {
            int d = (int)Math.sqrt(v);
            while (d > 0 && (v/d - d) < diff) {
                if (v%d == 0) {
                    res = new int[]{d, v/d};
                    diff = v/d-d;
                    break;
                }
                d--;
            }
        }
        return res;
    }
}
