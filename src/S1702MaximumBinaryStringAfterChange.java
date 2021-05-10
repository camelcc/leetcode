import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class S1702MaximumBinaryStringAfterChange {
    public String maximumBinaryString(String binary) {
        int zeros = 0, ones = 0;
        while(ones < binary.length() && binary.charAt(ones) == '1')
            ones ++ ;
        for(char c: binary.toCharArray()) {
            if(c == '0')
                zeros ++ ;
        }
        if(zeros == 0) return binary;
        char[] ar = new char[binary.length()];
        Arrays.fill(ar, '1');
        ar[ones + zeros-1] = '0';
        return String.valueOf(ar);
    }
}
