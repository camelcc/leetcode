public class S2079WateringPlants {
    public int wateringPlants(int[] plants, int capacity) {
        int res = 0;
        int c = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (c < plants[i]) {
                res += 2*i;
                c = capacity;
            }
            res++;
            c -= plants[i];
        }
        return res;
    }
}
