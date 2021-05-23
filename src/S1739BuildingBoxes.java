public class S1739BuildingBoxes {
    public int minimumBoxes(int n) {
        if (n <= 3) {
            return n;
        }
        int sum = 1, base = 1, step = 2, layer = 1;
        while (sum < n) {
            int nb = base + step;
            int ns = sum + nb;
            if (ns == n) {
                return nb;
            } else if (ns > n) {
                break;
            }
            // ns < n
            step++;
            layer++;
            sum = ns;
            base = nb;
        }
        for (int i = 0; i <= layer && sum < n; i++) {
            base++;
            sum += i+1;
        }
        return base;
    }
}
