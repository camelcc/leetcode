public class S2105WateringPlantsII {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int res = 0;
        int a = 0, b = plants.length-1;
        int ca = capacityA, cb = capacityB;
        while (a <= b) {
            if (a == b) {
                if (ca >= cb) { // use ca
                    if (ca < plants[a]) {
                        res++;
                    }
                } else { // use cb
                    if (cb < plants[a]) {
                        res++;
                    }
                }
                break;
            }
            if (ca < plants[a]) {
                res++;
                ca = capacityA;
            }
            ca -= plants[a];
            a++;
            if (cb < plants[b]) {
                res++;
                cb = capacityB;
            }
            cb -= plants[b];
            b--;
        }
        return res;
    }
}
