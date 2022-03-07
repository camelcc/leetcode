import java.util.TreeSet;

// https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/discuss/1823036/Java-solution-O(n2)
public class S2193MinimumNumberMovesMakePalindrome {
    public int minMovesToMakePalindrome(String s) {

        char[] cArr = s.toCharArray();
        int i = 0, j = s.length() - 1, count = 0;
        while(i < j) {

            /// character at begin equal with character at the end, move forward
            if (cArr[i] == cArr[j]) {
                i++;
                j--;
            } else {
                /*
                character at begin not equal with character at the end so we need to move the first
                character equal with start from the end

                Two case here:
                1. we able to find a character from the end that match with current start character theb
                we could swap them
                2. we unable to find the character match with current start character
                then we should move current start to the middle
                For example: abb => bab
                */

                ///find the first position from the end that match with character from start
                int k = j;
                while(k > i && cArr[k] != cArr[i]) {
                    k--;
                }

                /// we don't found anything, so we need to move start to middle
                if (k == i) {
                    swap(cArr, i, i + 1);
                    count++;
                } else {
                    /// we found a first character that match with start character
                    while(k < j) {
                        swap(cArr, k, k + 1);
                        k++;
                        count++;
                    }
                    i++;
                    j--;
                }

            }
        }

        return count;
    }

    private void swap(char[] cArr, int i, int j) {
        char ch = cArr[i];
        cArr[i] = cArr[j];
        cArr[j] = ch;
    }
}
