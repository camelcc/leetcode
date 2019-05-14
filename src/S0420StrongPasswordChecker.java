public class S0420StrongPasswordChecker {
    public int strongPasswordChecker(String s) {
        boolean lower = false, upper = false, digits = false;
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                lower = true;
            } else if (c >= 'A' && c <= 'Z') {
                upper = true;
            } else if (c >= '0' && c <= '9') {
                digits = true;
            }
        }

        int replaceNeeded = 0;
        int cnt = 1;
        int threes = 0, fours = 0, fives = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cnt++;
            } else {
                if (cnt < 3) {
                    cnt = 1;
                } else {
                    if (cnt % 3 == 0) {
                        threes++;
                    } else if (cnt % 3 == 1) {
                        fours++;
                    } else if (cnt % 3 == 2) {
                        fives++;
                    }

                    replaceNeeded += cnt/3;

                    cnt = 1;
                }
            }
        }
        if (cnt >= 3) {
            if (cnt % 3 == 0) {
                threes++;
            } else if (cnt % 3 == 1) {
                fours++;
            } else if (cnt % 3 == 2) {
                fives++;
            }
            replaceNeeded += cnt/3;
        }

        int missingKinds = (lower ? 0 : 1) + (upper ? 0 : 1) + (digits ? 0 : 1);
        if (s.length() < 6) {
            return Math.max(missingKinds, 6-s.length());
        } else if (s.length() <= 20) {
            return Math.max(replaceNeeded, missingKinds);
        } else {
            assert s.length() > 20;
            int deleteNeeded = s.length()-20;

            // saved replacement by deletion
            replaceNeeded -= Math.min(deleteNeeded, threes); // delete the last char each threes
            deleteNeeded -= threes;

            if (deleteNeeded > 0) {
                replaceNeeded -= Math.min(deleteNeeded, fours*2)/2; // delete last two chars each fours
                deleteNeeded -= fours*2;
            }

            if (deleteNeeded > 0) {
                replaceNeeded -= Math.min(deleteNeeded, fives*3)/3; // delete last three chars each fives
                deleteNeeded -= fives*3;
            }

            if (deleteNeeded > 0) { // each 3 deletes can reduce 1 replacements, until replacement is 0
                replaceNeeded -= deleteNeeded/3;
            }

            // replaceNeeded can be < 0
            return s.length()-20+ Math.max(missingKinds, replaceNeeded);
        }
    }
}
