package peter;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * For example, Given the following matrix:
 * 
 * <pre>
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * </pre>
 * 
 * *
 * 
 * @author ylkang May 11, 2015
 */
public class _054_Spiral_Matrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}

		int totalSize = matrix[0].length * matrix.length;

		int[] points = { 0, 0 };
		int round = 0;
		while (result.size() != totalSize) {
			points = moveRight(matrix, points, result, round, totalSize);
			points = moveDown(matrix, points, result, round, totalSize);
			points = moveLeft(matrix, points, result, round, totalSize);
			points = moveUp(matrix, points, result, round, totalSize);
			round++;
		}

		return result;
	}

	private int[] moveUp(int[][] matrix, int[] points, List<Integer> result,
			int round, int totalSize) {
		if (result.size() == totalSize) {
			return points;
		}
		int upMost = round;
		for (int i = points[0]; i > upMost; i--) {
			result.add(matrix[i][points[1]]);
		}
		return new int[] { upMost + 1, points[1] + 1 };
	}

	private int[] moveLeft(int[][] matrix, int[] points, List<Integer> result,
			int round, int totalSize) {
		if (result.size() == totalSize) {
			return points;
		}
		int leftMost = round;
		for (int i = points[1]; i >= leftMost; i--) {
			result.add(matrix[points[0]][i]);
		}
		return new int[] { points[0] - 1, leftMost };
	}

	private int[] moveDown(int[][] matrix, int[] points, List<Integer> result,
			int round, int totalSize) {
		if (result.size() == totalSize) {
			return points;
		}
		int downMost = matrix.length - round;
		for (int i = points[0]; i < downMost; i++) {
			result.add(matrix[i][points[1]]);
		}
		return new int[] { downMost - 1, points[1] - 1 };
	}

	private int[] moveRight(int[][] matrix, int[] points, List<Integer> result,
			int round, int totalSize) {
		if (result.size() == totalSize) {
			return points;
		}
		int rightMost = matrix[0].length - round;
		for (int i = points[1]; i < rightMost; i++) {
			result.add(matrix[points[0]][i]);
		}
		return new int[] { points[0] + 1, rightMost - 1, };
	}

	public static void main(String[] args) {

		System.out.println(new _054_Spiral_Matrix().spiralOrder(new int[][] { {
				2, 3 } }));
		System.out.println(new _054_Spiral_Matrix().spiralOrder(new int[][] {
				{ 1, 2, 3 }, { 10, 11, 4 }, { 9, 12, 5 }, { 8, 7, 6 } }));
	}
}