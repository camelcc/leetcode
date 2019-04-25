public class S0042TrappingRainWater {
    public int trap(int[] height) {
        int res = 0;

        int left = 0;
        while (left < height.length) {
            int right = left+1;
            while (right < height.length && height[right] < height[left]) {
                right++;
            }
            if (right == height.length) {
                break;
            }

            int b =  Math.min(height[left], height[right]);
            for (int i = left; i < right; i++) {
                if (height[i] >= b) {
                    continue;
                }
                res += b-height[i];
            }

            left = right;
        }

        int right = height.length-1;
        while (right > left) {
            int l = right-1;
            while (l > left && height[l] < height[right]) {
                l--;
            }
            int b = Math.min(height[l], height[right]);
            for (int i = l; i < right; i++) {
                if (height[i] >= b) {
                    continue;
                }
                res += b-height[i];
            }
            right = l;
        }

        return res;
    }
}
