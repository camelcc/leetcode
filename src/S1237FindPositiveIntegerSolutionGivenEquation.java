import java.util.ArrayList;
import java.util.List;

public class S1237FindPositiveIntegerSolutionGivenEquation {
  public static  class CustomFunction {
      // Returns f(x, y) for any given positive integers x and y.
      public int f(int x, int y) {return x*y;}
  };

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        int y = 1, up = 1000;
        while (y <= 1000) {
            int xlo = 1, xhi = up;
            while (xlo <= xhi) {
                int mid = xlo + (xhi-xlo)/2;
                int v = customfunction.f(mid, y);
                if (v < z) {
                    xlo = mid+1;
                } else if (v == z) {
                    List<Integer> t = new ArrayList<>();
                    t.add(mid);
                    t.add(y);
                    res.add(t);
                    xhi = mid;
                    break;
                } else { // v > z
                    xhi = mid-1;
                }
            }

            up = xhi;
            y++;
        }
        return res;
    }
}
