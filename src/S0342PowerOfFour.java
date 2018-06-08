public class S0342PowerOfFour {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        return (num & 0xAAAAAAAA) == 0 && ((num & (num -1)) == 0);
    }
}
