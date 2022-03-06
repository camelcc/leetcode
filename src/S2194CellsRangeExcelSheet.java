import java.util.ArrayList;
import java.util.List;

public class S2194CellsRangeExcelSheet {
    public List<String> cellsInRange(String s) {
        char c1 = s.charAt(0), r1 = s.charAt(1), c2 = s.charAt(3), r2 = s.charAt(4);
        List<String> res = new ArrayList();
        for (char c = c1; c <= c2; c++) {
            for (char r = r1; r <= r2; r++) {
                res.add(new String(new char[]{c, r}));
            }
        }
        return res;
    }
}
