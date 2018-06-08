public class S0367ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        if (num == 0) {
            return true;
        }

        float torelance = 0.001f;
        float guess = 1;
        float improve = guess;
        do {
            guess = improve;
            if (guess*guess == num) {
                break;
            }
            improve = (guess + 1.0f*num/guess)/2;
        } while (Math.abs(guess-improve) > torelance);
        int floor = (int)Math.floor(guess);
        int ceil = (int)Math.ceil(guess);
        return floor*floor == num || ceil*ceil == num;
    }
}
