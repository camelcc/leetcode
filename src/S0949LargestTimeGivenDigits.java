public class S0949LargestTimeGivenDigits {
    public String largestTimeFromDigits(int[] A) {
        int[] digits = new int[10];
        for (int a : A) {
            digits[a]++;
        }
        for (int hh = 2; hh >= 0; hh--) {
            if (digits[hh] == 0) {
                continue;
            }
            digits[hh]--;

            for (int hl = (hh == 2 ? 3 : 9); hl >= 0; hl--) {
                if (digits[hl] == 0) {
                    continue;
                }
                digits[hl]--;

                for (int sh = 5; sh >= 0; sh--) {
                    if (digits[sh] == 0) {
                        continue;
                    }
                    digits[sh]--;

                    for (int sl = 9; sl >= 0; sl--) {
                        if (digits[sl] == 0) {
                            continue;
                        }
                        return String.format("%d%d:%d%d", hh, hl, sh, sl);
                    }

                    digits[sh]++;
                }

                digits[hl]++;
            }

            digits[hh]++;
        }
        return "";
    }
}
