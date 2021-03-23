public class S1603DesignParkingSystem {
    class ParkingSystem {
        private int b = 0;
        private int m = 0;
        private int s = 0;
        private int cb;
        private int cm;
        private int cs;

        public ParkingSystem(int big, int medium, int small) {
            cb = big;
            cm = medium;
            cs = small;
        }

        public boolean addCar(int carType) {
            switch (carType) {
                case 1:
                    if (b >= cb) {
                        return false;
                    }
                    b++;
                    break;
                case 2:
                    if (m >= cm) {
                        return false;
                    }
                    m++;
                    break;
                case 3:
                    if (s >= cs) {
                        return false;
                    }
                    s++;
                    break;
            }
            return true;
        }
    }
}
