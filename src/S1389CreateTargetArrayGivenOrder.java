import java.util.ArrayList;

public class S1389CreateTargetArrayGivenOrder {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < index.length; i++) {
            data.add(index[i], nums[i]);
        }
        int[] res = new int[data.size()];
        for (int i = 0; i < data.size(); i++) {
            res[i] = data.get(i);
        }
        return res;
    }
}
