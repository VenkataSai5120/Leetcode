class Codec {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 6;

    private Map<String, String> urlToCode = new HashMap<>();
    private Map<String, String> codeToUrl = new HashMap<>();

    public String encode(String longUrl) {
        while (!urlToCode.containsKey(longUrl)) {
            StringBuilder codeBuilder = new StringBuilder();
            Random random = new Random();
            for (int i = 0; i < CODE_LENGTH; i++) {
                int randomIndex = random.nextInt(ALPHABET.length());
                codeBuilder.append(ALPHABET.charAt(randomIndex));
            }
            String code = codeBuilder.toString();
            if (!codeToUrl.containsKey(code)) {
                urlToCode.put(longUrl, code);
                codeToUrl.put(code, longUrl);
            }
        }
        return "http://tinyurl.com/" + urlToCode.get(longUrl);
    }

    public String decode(String shortUrl) {
        String code = shortUrl.substring(shortUrl.length() - CODE_LENGTH);
        return codeToUrl.get(code);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));