package peter;

/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character b) Delete a character c) Replace a character
 * 
 * @author ylkang Jun 8, 2015
 */
public class _072_Edit_Distance {

	public int minDistance(String word1, String word2) {
		if (word1 == null && word2 == null) {
			return 0;
		}
		if (word1 == null && word2 != null) {
			return word2.length();
		}
		if (word2 == null && word1 != null) {
			return word1.length();
		}

		if (word1.equals(word2) || word1 == word2) {
			return 0;
		}

		int[][] matrix = new int[word1.length() + 1][word2.length() + 1];

		for (int i = 1; i <= word1.length(); i++) {
			matrix[i][0] = i;
		}
		for (int i = 1; i <= word2.length(); i++) {
			matrix[0][i] = i;
		}
		for (int width = 1; width < matrix[0].length; width++) {
			for (int height = 1; height < matrix.length; height++) {
				int delta = 0;
				if (word2.charAt(width - 1) != word1.charAt(height - 1)) {
					delta = 1;
				}
				matrix[height][width] = Math.min(Math.min(
						matrix[height - 1][width] + 1,
						matrix[height][width - 1] + 1),
						matrix[height - 1][width - 1] + delta);
			}
		}
		return matrix[word1.length()][word2.length()];
	}

	public static void main(String[] args) {
		// System.out.println(new _072_Edit_Distance().minDistance("aaa",
		// "bbb"));
		System.out.println(new _072_Edit_Distance().minDistance("a", "b"));
		System.out.println(new _072_Edit_Distance().minDistance("a", "ab"));

		System.out.println(new _072_Edit_Distance().minDistance("abb", "bba"));
	}
}