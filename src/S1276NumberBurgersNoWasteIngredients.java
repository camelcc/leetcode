import java.util.ArrayList;
import java.util.List;

public class S1276NumberBurgersNoWasteIngredients {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();
        int j = (tomatoSlices-2*cheeseSlices);
        if (j < 0 || j%2 != 0) {
            return res;
        }
        j = j/2;

        int s = cheeseSlices-j;
        if (s < 0) {
            return res;
        }
        res.add(j);
        res.add(s);
        return res;
    }
}
