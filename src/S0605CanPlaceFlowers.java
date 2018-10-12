public class S0605CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        int current = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (i > 0 && flowerbed[i-1] == 1) {
                    flowerbed[i] = 2;
                }
                if (i < flowerbed.length-1 && flowerbed[i+1] == 1) {
                    flowerbed[i] = 2;
                }
                if (flowerbed[i] != 0) {
                    continue;
                }

                current++;
            } else {
                count += (current+1)/2;
                current = 0;
            }
        }
        count += (current+1)/2;

        return count >= n;
    }
}
