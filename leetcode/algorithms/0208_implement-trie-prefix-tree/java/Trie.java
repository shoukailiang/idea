import java.util.TreeMap;

class Trie {

  private class Node {
    public boolean isWord;// 判断是否到达单词尾部
    public TreeMap<Character, Node> next;

    public Node(boolean isWord) {
      this.isWord = isWord;
      next = new TreeMap<>();
    }

    public Node() {
      this(false);
    }
  }

  private Node root;

  /** Initialize your data structure here. */
  public Trie() {
    root = new Node();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    Node cur = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (cur.next.get(c) == null) {
        cur.next.put(c, new Node());
      }
      cur = cur.next.get(c);
    }
    cur.isWord = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    Node cur = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (cur.next.get(c) == null) {
        return false;
      }
      cur = cur.next.get(c);
    }
    return cur.isWord;
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    // // 查询是否在Trie中有单词以prefix为前缀
    Node cur = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (cur.next.get(c) == null) {
        return false;
      }
      cur = cur.next.get(c);
    }
    return true;
  }
} 

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */