import java.util.List;

public class S0120Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        int[] sums = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            sums[i] = triangle.get(triangle.size()-1).get(i);
        }

        for (int row = triangle.size()-2; row >= 0; row--) {
            for (int column = 0; column <= row; column++) {
                sums[column] = Math.min(sums[column], sums[column+1]) + triangle.get(row).get(column);
            }
        }
        return sums[0];
    }
}
