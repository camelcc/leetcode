public class S1616SplitTwoStringsMakePalindrome {
    public boolean checkPalindromeFormation(String a, String b) {
        int len = a.length();
        if (len <= 1) {
            return true;
        }
        return valid(a, b) || valid(b, a);
    }

    private boolean valid(String a, String b) {
        int len = a.length();
        int pa = 0;
        while (pa < a.length() && a.charAt(pa) == b.charAt(len-1-pa)) {
            pa++;
        }
        int mid = len/2;
        if (pa >= mid) {
            return true;
        }
        int l = mid-1, r = mid+1;
        if (len%2 == 0) {
            r = mid;
        }
        return valid(a, l, r, pa) || valid(b, l, r, pa);
    }

    private boolean valid(String a, int l, int r, int pa) {
        while (l >= pa && a.charAt(l) == a.charAt(r)) {
            l--;
            r++;
        }
        return l < pa;
    }
}
