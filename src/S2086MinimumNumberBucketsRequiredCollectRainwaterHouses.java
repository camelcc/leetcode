public class S2086MinimumNumberBucketsRequiredCollectRainwaterHouses {
    public int minimumBuckets(String street) {
        int bucket = -2;
        int res = 0;
        for (int i = 0; i < street.length(); i++) {
            char c = street.charAt(i);
            if (c != 'H') {
                continue;
            }
            if (bucket == i-1) {
                continue;
            }
            boolean canPutRight = (i != street.length()-1 && street.charAt(i+1) != 'H');
            if (!canPutRight) { // have to be left
                if (i == 0 || street.charAt(i-1) == 'H') {
                    return -1;
                }
                res++;
                bucket = i-1;
                continue;
            }
            // put on right
            res++;
            bucket = i+1;
        }
        return res;
    }
}
