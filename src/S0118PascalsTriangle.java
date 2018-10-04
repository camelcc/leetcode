import java.util.ArrayList;
import java.util.List;

public class S0118PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        List<Integer> preRow = new ArrayList<>();
        preRow.add(1);
        res.add(preRow);
        if (numRows == 1) {
            return res;
        }

        for (int row = 2; row <= numRows; row++) {
            List<Integer> num = new ArrayList<>();
            num.add(1);
            for (int c = 0; c < row-2; c++) {
                num.add(preRow.get(c) + preRow.get(c+1));
            }
            num.add(1);
            res.add(num);
            preRow = num;
        }

        return res;
    }
}
