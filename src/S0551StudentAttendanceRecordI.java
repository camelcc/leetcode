public class S0551StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        if (s.contains("LLL")) {
            return false;
        }
        int first = s.indexOf('A');
        if (first != -1) {
            return s.indexOf('A', first+1) == -1;
        } else {
            return true;
        }
    }
}
