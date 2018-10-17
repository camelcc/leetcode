public class S0717_12BitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        return onebit(bits, 0);
    }

    private boolean onebit(int[] bits, int start) {
        if (start >= bits.length) {
            return false;
        }
        if (start == bits.length-1) {
            return true;
        }
        // start < bits.len -1;
        if (bits[start] == 0) {
            return onebit(bits, start+1);
        } else { // 1
            return onebit(bits, start+2);
        }
    }
}
