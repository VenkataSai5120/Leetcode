class TrieNode {
    TrieNode[] links;
    boolean flag;

    public TrieNode() {
        this.links = new TrieNode[26];
    }

    public boolean containsKey(char c) {
        return this.links[c - 'a'] != null;
    }

    public void put(char c, TrieNode node) {
        this.links[c - 'a'] = node;
    }

    public TrieNode get(char c) {
        return this.links[c - 'a'];
    }

    public void setEnd() {
        this.flag = true;
    }

    public boolean isEnd() {
        return this.flag;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = this.root;

        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) node.put(c, new TrieNode());
            node = node.get(c);
        }

        node.setEnd();
    }

    public String findRoot(String word) {
        TrieNode node = this.root;
        
        StringBuilder sb = new StringBuilder();
        System.out.println(word);
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) return word;
            node = node.get(c);
            sb.append(c);
            if (node.isEnd()) break;
        }

        return sb.toString();
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        Trie trie = new Trie();
        StringBuilder res = new StringBuilder();

        for (String root : dictionary) {
            trie.insert(root);
        }

        for (String word : words) {
            String root = trie.findRoot(word);
            res.append(root + " ");
        }

        return res.toString().trim();
    }
}