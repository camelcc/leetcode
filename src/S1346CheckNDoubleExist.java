import java.util.HashSet;

public class S1346CheckNDoubleExist {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> exist = new HashSet<>();
        for (int a : arr) {
            if (exist.contains(a)) {
                return true;
            }
            if (a%2 == 0) {
                exist.add(a/2);
            }
            exist.add(a*2);
        }
        return false;
    }
}
