public class S0810ChalkboardXORGame {
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        return xor == 0 || nums.length%2 == 0;
    }
}
