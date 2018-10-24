public class S0011ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1, area = 0;
        while (left < right) {
            area = Math.max(area, (right-left)*Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
