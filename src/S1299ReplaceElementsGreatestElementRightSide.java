public class S1299ReplaceElementsGreatestElementRightSide {
    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length-1];
        for (int i = arr.length-2; i >= 0; i--) {
            int t = max;
            max = Math.max(max, arr[i]);
            arr[i] = t;
        }
        arr[arr.length-1] = -1;
        return arr;
    }
}
