package peter;

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up: Could you do this in-place?
 * 
 * @author ylkang Feb 6, 2015
 */
public class _048_Rotate_Image {

	/**
	 * <pre>
	 * 1	2	3	4		13	9	5	1
	 * 5	6	7	8	=>	14	10	6	2
	 * 9	10	11	12		15	11	7	3
	 * 13	14	15	16		16	12	8	4
	 * 
	 * </pre>
	 * 
	 * 
	 * @param matrix
	 */
	public static void rotate(int[][] matrix) {
		if (matrix == null)
			return;

		// a[i][j]->a[j][n-i-1]
		int len = matrix.length;
		int border = len / 2;

		for (int i = 0; i < border; i++) {
			for (int j = 0; j < border; j++) {
				int m = i;
				int n = j;

				int tmp = matrix[m][n];
				matrix[m][n] = matrix[len - n - 1][m];

				int mm = m;
				m = len - n - 1;
				n = mm;
				matrix[m][n] = matrix[len - n - 1][m];

				mm = m;
				m = len - n - 1;
				n = mm;

				matrix[m][n] = matrix[len - n - 1][m];
				mm = m;
				m = len - n - 1;
				n = mm;

				matrix[m][n] = tmp;
			}
		}

		if ((len & 1) == 1) {
			for (int i = 0; i < len / 2; i++) {
				int tmp = matrix[i][len / 2];
				matrix[i][len / 2] = matrix[len / 2][i];
				matrix[len / 2][i] = matrix[len - 1 - i][len / 2];
				matrix[len - 1 - i][len / 2] = matrix[len / 2][len - 1 - i];
				matrix[len / 2][len - 1 - i] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		int[][] m = new int[][] { { 1, 2, 3, 4, 5 }, { 15, 16, 17, 18, 19 },
				{ 29, 30, 31, 32, 33 }, { 43, 44, 45, 46, 47 },
				{ 53, 54, 55, 56, 57 } };
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}

		rotate(m);
		System.out.println();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}
}