public class S0482LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        String s = S.toUpperCase().replaceAll("-", "");

        StringBuilder builder = new StringBuilder();

        int i = s.length()-1;
        for (; i>=K; i=i-K) {
            builder.insert(0, s.substring(i-K+1, i+1));
            builder.insert(0, "-");
        }
        if (i >= 0) {
            builder.insert(0, s.substring(0, i+1));
        }
        return builder.toString();
    }
}
