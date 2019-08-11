public class S01154DayYear {
    public int dayOfYear(String date) {
        String[] t = date.split("-");
        int y = Integer.valueOf(t[0]);
        int m = Integer.valueOf(t[1]);
        int d = Integer.valueOf(t[2]);
        int[] dm = new int[] {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        int res = dm[m-1]+d;
        if (y%4 == 0 && !(y%100 == 0 && y%400 != 0) && m > 2) {
            res++;
        }
        return res;
    }
}
