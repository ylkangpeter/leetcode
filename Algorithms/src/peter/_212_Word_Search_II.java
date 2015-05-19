package peter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _212_Word_Search_II {

	// private static final String[] ARR = {'a','b','c','d'}
	private static class Trie {
		public Trie[] next = new Trie[26];
		public boolean wordHere = false;

		public void add(String word) {
			add(this, word, 0);
		}

		private void add(Trie trie, String word, int offset) {
			if (word == null || word.length() == 0) {
				return;
			}

			if (offset >= word.length()) {
				trie.wordHere = true;
				return;
			}

			int a = word.charAt(offset) - 'a';
			if (trie.next[a] == null) {
				trie.next[a] = new Trie();
			}
			add(trie.next[a], word, offset + 1);

		}
	}

	public List<String> findWords(char[][] board, String[] words) {
		Set<String> result = new HashSet<String>();

		if (words == null || words.length == 0) {
			return new ArrayList<String>();
		}

		// build trie
		Trie trie = new Trie();
		for (String word : words) {
			trie.add(word);
		}

		@SuppressWarnings("unchecked")
		ArrayList<String>[] m = new ArrayList[26];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				char c = board[i][j];
				if (m[c - 'a'] == null) {
					m[c - 'a'] = new ArrayList<String>();
				}
				m[c - 'a'].add(i + "_" + j);
			}
		}

		for (int inx = 0; inx < trie.next.length; inx++) {
			if (trie.next[inx] == null || m[inx] == null || m[inx].isEmpty()) {
				continue;
			}
			for (String str : m[inx]) {
				boolean[][] mask = new boolean[board.length][board[0].length];
				String[] tmp = str.split("_");
				int i = Integer.parseInt(tmp[0]);
				int j = Integer.parseInt(tmp[1]);
				mask[i][j] = true;
				StringBuilder sb = new StringBuilder();
				sb.append((char) ('a' + inx));
				find(result, trie.next[inx], sb, mask, board, i, j);
			}
		}

		List<String> list = new ArrayList<String>();
		list.addAll(result);

		return list;
	}

	private void find(Set<String> result, Trie trie, StringBuilder sb,
			boolean[][] mask, char[][] board, int row, int col) {

		if (trie == null) {
			return;
		}

		int[][] offset = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

		if (trie.wordHere) {
			result.add(sb.toString());
		}

		for (int off = 0; off < trie.next.length; off++) {
			for (int i = 0; i < offset.length; i++) {
				if (isQualified(offset[i], row, col, board)) {
					if (board[row + offset[i][0]][col + offset[i][1]] == off + 'a'
							&& !mask[row + offset[i][0]][col + offset[i][1]]) {
						mask[row + offset[i][0]][col + offset[i][1]] = true;
						sb.append((char) ('a' + off));
						find(result, trie.next[off], sb, mask, board, row
								+ offset[i][0], col + offset[i][1]);
						sb.deleteCharAt(sb.length() - 1);
						mask[row + offset[i][0]][col + offset[i][1]] = false;
					}
				}
			}
		}
	}

	private boolean isQualified(int[] offset, int row, int col, char[][] board) {
		if (row + offset[0] >= 0 && row + offset[0] < board.length
				&& col + offset[1] >= 0 && col + offset[1] < board[0].length) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
//		String[] words = { "a" };
//		char[][] chars = { { 'a', 'a' } };
		 String[] words = { "oath", "pea", "eat", "rain" };
		 char[][] chars = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' },
		 { 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } };

		System.out.println(new _212_Word_Search_II().findWords(chars, words));
	}
}
