class MagicDictionary {
    Map<Integer, List<String>> map;

    public MagicDictionary() {
        this.map = new HashMap<>();
    }
    
    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            int len = word.length();
            List<String> list = map.getOrDefault(len, new ArrayList<>());
            list.add(word);
            map.put(len, list);
        }
    }
    
    public boolean search(String searchWord) {
        int len = searchWord.length();
        if (!map.containsKey(len)) {
            return false;
        }

        for (String word : map.get(len)) {
            int count = 0;
            for (int i = 0 ; i < len; i++) {
                if (word.charAt(i) != searchWord.charAt(i)) {
                    count++;
                }
            }

            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */