public class S1442CountTripletsThatCanFormTwoArraysEqualXOR {
    public int countTriplets(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int xor = arr[i];
            for (int k = i+1; k < arr.length; k++) {
                xor = xor^arr[k];
                if (xor == 0) {
                    // count [i, j, k]
                    res += k-i;
                }
            }
        }
        return res;
    }
}
