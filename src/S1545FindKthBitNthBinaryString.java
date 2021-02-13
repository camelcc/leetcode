public class S1545FindKthBitNthBinaryString {
    public char findKthBit(int n, int k) {
        if (k == 1) {
            return '0';
        }
        int c = (0x1 << n)-1;
        int half = c >> 1;
        if (k <= half) {
            return findKthBit(n-1, k);
        } else if (k == half+1) {
            return '1';
        } else {
            char res = findKthBit(n-1, c-k+1);
            if (res == '0') {
                return '1';
            } else {
                return '0';
            }
        }
    }
}
