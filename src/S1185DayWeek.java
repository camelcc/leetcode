public class S1185DayWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int initial = 5;
        int d = 1, m = 1, y = 1971, diff = 0;
        while (y < year) {
            diff += isLeap(y) ? 366 : 365;
            y++;
        }
        while (m < month) {
            diff += days[m];
            m++;
        }
        if (m > 2 && isLeap(year)) {
            diff++;
        }
        diff += day-1;
        diff = diff%7;
        return week[(5+diff)%7];
    }

    private boolean isLeap(int year) {
        if (year%4 != 0) {
            return false;
        } else if (year%100 != 0) {
            return true;
        } else if (year%400 != 0) {
            return false;
        } else {
            return true;
        }
    }
}
