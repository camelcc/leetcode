public class S2069WalkingRobotSimulationII {
    public static class Robot {
        // 0 - E, 1 - N, 2 - W, 3 - S
        int x = 0, y = 0, d = 0;
        int[][] dp = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        String[] dir = new String[]{"East", "North", "West", "South"};

        int w;
        int h;
        int move;

        public Robot(int width, int height) {
            w = width;
            h = height;
            move = 0;
        }

        public void move(int num) {
            if (x == 0 && y == 0 && d == 0) {
                d = 3;
            }
            move += num;
        }

        private void doMove() {
            int r = 2*(w+h)-4;
            move = move%r;
            if (move == 0) {
                return;
            }
            int mx = x + move * dp[d][0];
            int my = y + move * dp[d][1];
            if (mx < 0 || mx >= w || my < 0 || my >= h) {
                if (d == 0) {
                    move -= w-1-x;
                    x = w-1;
                    y = 0;
                } else if (d == 1) {
                    move -= h-1-y;
                    x = w-1;
                    y = h-1;
                } else if (d == 2) {
                    move -= x;
                    x = 0;
                    y = h-1;
                } else if (d == 3) {
                    move -= y;
                    x = 0;
                    y = 0;
                }
                d = (d+1)%4;
                doMove();
            } else {
                move = 0;
                x = mx;
                y = my;
            }
        }

        public int[] getPos() {
            if (move != 0) {
                doMove();
            }
            return new int[]{x, y};
        }

        public String getDir() {
            if (move != 0) {
                doMove();
            }
            return dir[d];
        }
    }
}
