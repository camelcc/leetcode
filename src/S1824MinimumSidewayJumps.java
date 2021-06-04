public class S1824MinimumSidewayJumps {
    public int minSideJumps(int[] obstacles) {
        int[] current = new int[]{1, 0, 1};
        for (int i = 1; i < obstacles.length; i++) {
            int l1 = Integer.MAX_VALUE;
            if (obstacles[i] != 1) {
                l1 = Math.min(l1, current[0]);
                if (current[1] != Integer.MAX_VALUE && obstacles[i] != 2) {
                    l1 = Math.min(l1, current[1]+1);
                }
                if (current[2] != Integer.MAX_VALUE && obstacles[i] != 3) {
                    l1 = Math.min(l1, current[2]+1);
                }
            }
            int l2 = Integer.MAX_VALUE;
            if (obstacles[i] != 2) {
                if (current[0] != Integer.MAX_VALUE && obstacles[i] != 1) {
                    l2 = Math.min(l2, current[0]+1);
                }
                l2 = Math.min(l2, current[1]);
                if (current[2] != Integer.MAX_VALUE && obstacles[i] != 3) {
                    l2 = Math.min(l2, current[2]+1);
                }
            }
            int l3 = Integer.MAX_VALUE;
            if (obstacles[i] != 3) {
                if (current[0] != Integer.MAX_VALUE && obstacles[i] != 1) {
                    l3 = Math.min(l3, current[0]+1);
                }
                if (current[1] != Integer.MAX_VALUE && obstacles[i] != 2) {
                    l3 = Math.min(l3, current[1]+1);
                }
                l3 = Math.min(l3, current[2]);
            }
            current = new int[]{l1, l2, l3};
        }
        return Math.min(current[0], Math.min(current[1], current[2]));
    }
}
