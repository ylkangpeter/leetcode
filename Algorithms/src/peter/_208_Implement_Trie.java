package peter;

import java.util.HashMap;
import java.util.Map;

class TrieNode {

	private boolean wordHere = false;

	private Map<Character, TrieNode> rootMap = new HashMap<Character, TrieNode>();

	// Initialize your data structure here.
	public TrieNode() {
	}

	public void insert(char[] chars) {
		insert(chars, 0, this);
	}

	public boolean search(char[] chars) {
		return search(chars, 0, this, true);
	}

	public boolean startsWith(char[] chars) {
		return search(chars, 0, this, false);
	}

	private void insert(char[] chars, int offset, TrieNode tree) {

		if (offset >= chars.length) {
			tree.wordHere = true;
			return;
		}

		char root = chars[offset];
		TrieNode trie = new TrieNode();
		if (tree.rootMap.get(root) == null) {
			tree.rootMap.put(root, trie);
		} else {
			trie = tree.rootMap.get(root);
		}

		insert(chars, offset + 1, trie);
	}

	private boolean search(char[] chars, int offset, TrieNode tree,
			boolean exactMatch) {
		if (offset >= chars.length) {
			if (exactMatch) {
				if (tree.wordHere) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		}

		char root = chars[offset];
		TrieNode trie = new TrieNode();
		if (tree.rootMap.get(root) == null) {
			return false;
		} else {
			trie = tree.rootMap.get(root);
		}

		return search(chars, offset + 1, trie, exactMatch);
	}
}

public class _208_Implement_Trie {
	private TrieNode root;

	public _208_Implement_Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		if (word == null || word.length() == 0) {
			return;
		}
		root.insert(word.toCharArray());
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		if (word == null || word.length() == 0) {
			return false;
		}
		return root.search(word.toCharArray());

	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		if (prefix == null || prefix.length() == 0) {
			return false;
		}
		return root.startsWith(prefix.toCharArray());

	}

	public static void main(String[] args) {
		_208_Implement_Trie tree = new _208_Implement_Trie();
		tree.insert("somestring");
		tree.insert("app");
		tree.insert("apple");
		tree.insert("beer");
		tree.insert("add");
		tree.insert("jam");
		tree.insert("rental");
		 System.out.println(tree.search("apps"));
		 System.out.println(tree.search("app"));
		 System.out.println(tree.search("ad"));
		 System.out.println(tree.search("applepie"));
		 System.out.println(tree.search("rest"));
		System.out.println(tree.search("jan"));
		System.out.println(tree.search("rent"));
		System.out.println(tree.search("beer"));
		System.out.println(tree.search("jam"));
		System.out.println(tree.startsWith("apps"));
		System.out.println(tree.startsWith("app"));
		System.out.println(tree.startsWith("ad"));
		System.out.println(tree.startsWith("applepie"));
		System.out.println(tree.startsWith("rest"));
		System.out.println(tree.startsWith("jan"));
		System.out.println(tree.startsWith("rent"));
		System.out.println(tree.startsWith("beer"));
		System.out.println(tree.startsWith("jam"));
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");