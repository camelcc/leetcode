import java.util.HashMap;

public class S0535EncodeDecodeTinyURL {
    public class Codec {
        private static final String SEED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        private static final String BASE = "http://tinyurl.com/";
        private HashMap<String, String> url2Key = new HashMap<>();
        private HashMap<String, String> key2Url = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if (longUrl == null || longUrl.isEmpty()) {
                return "";
            }
            if (url2Key.containsKey(longUrl)) {
                return url2Key.get(longUrl);
            }

            StringBuilder key = null;
            // keep generating keys until a unique one is found
            do {
                key = new StringBuilder();
                for (int i = 0; i < 6; i++) {
                    int r = (int)(Math.random() * SEED.length());
                    key.append(SEED.charAt(r));
                }
            } while (key2Url.containsKey(key));

            key2Url.put(key.toString(), longUrl);
            url2Key.put(longUrl, key.toString());

            return BASE + key.toString();
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            if (shortUrl == null || shortUrl.isEmpty()) {
                return "";
            }
            String key = shortUrl.substring(BASE.length());
            String res = key2Url.get(key);
            url2Key.remove(res);
            key2Url.remove(key);
            return res;
        }
    }
}
