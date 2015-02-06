package peter;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * click to show follow up.
 * 
 * Follow up: A rather straight forward solution is a two-pass algorithm using
 * counting sort. First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 * @author ylkang Feb 5, 2015
 */
public class _075_Sort_Colors {

	public void sortColors_2times(int[] A) {
		int[] tmp = new int[3];
		for (int i = 0; i < A.length; i++) {
			tmp[A[i]]++;
		}
		for (int i = 0; i < tmp[0]; i++) {
			A[i] = 0;
		}

		for (int i = tmp[0]; i < tmp[0] + tmp[1]; i++) {
			A[i] = 1;
		}

		for (int i = tmp[0] + tmp[1]; i < A.length; i++) {
			A[i] = 2;
		}
	}

	public static void sortColor_1time(int[] A) {
		if (A.length == 0 || A == null)
			return;
		int pointerOne = 0;
		int pointerTwo = A.length - 1;
		for (int i = 0; i < A.length; i++) {
			if (pointerTwo + 1 == i) {
				break;
			}
			if (A[i] == 0) {
				int temp = A[i];
				A[i] = A[pointerOne];
				A[pointerOne] = temp;
				pointerOne++;
			} else if (A[i] == 2) {
				int temp = A[i];
				A[i] = A[pointerTwo];
				A[pointerTwo] = temp;
				pointerTwo--;
				i--;
			}
		}
	}

	public static void main(String[] args) {
		sortColor_1time(new int[] { 2, 1, 0, 1, 1, 0, 2 });
	}

}