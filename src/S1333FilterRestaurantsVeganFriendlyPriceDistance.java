import java.util.*;

public class S1333FilterRestaurantsVeganFriendlyPriceDistance {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < restaurants.length; i++) {
            if (restaurants[i][3] > maxPrice || restaurants[i][4] > maxDistance) {
                continue;
            }
            if (veganFriendly == 1 && restaurants[i][2] != 1) {
                continue;
            }
            res.add(i);
        }
        res.sort((Integer o1, Integer o2) -> {
            if (restaurants[o1][1] != restaurants[o2][1]) {
                return restaurants[o2][1]-restaurants[o1][1];
            }
            return restaurants[o2][0]-restaurants[o1][0];
        });
        List<Integer> r = new ArrayList<>();
        for (int i : res) {
            r.add(restaurants[i][0]);
        }
        return r;
    }
}
