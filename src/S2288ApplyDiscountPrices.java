public class S2288ApplyDiscountPrices {
    public String discountPrices(String sentence, int discount) {
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (!isPrice(words[i])) {
                sb.append(words[i]);
            } else {
                sb.append(discount(words[i], discount));
            }

            if (i != words.length-1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    private boolean isPrice(String word) {
        if (word.isBlank() || word.charAt(0) != '$') {
            return false;
        }
        try {
            Long.parseLong(word.substring(1));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String discount(String word, int discount) {
        long value = Long.parseLong(word.substring(1));
        double res = value * 1.0 * (100-discount) / 100;
        return String.format("$%.2f", res);
    }
}
