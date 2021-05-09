public class S1700NumberStudentsUnableEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        int zero = 0, one = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == 0) {
                zero++;
            } else {
                one++;
            }
        }
        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0) {
                if (zero == 0) {
                    break;
                }
                zero--;
            } else if (sandwiches[i] == 1) {
                if (one == 0) {
                    break;
                }
                one--;
            }
        }
        return zero+one;
    }
}
