import java.util.Arrays;

public class S1894FindStudentWillReplaceChalk {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
        }
        if (k >= sum) {
            k = k%(int)sum;
        }
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > k) {
                return i;
            }
            k -= chalk[i];
        }
        return -1;
    }
}
