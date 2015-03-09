package peter;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example: A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 * @author ylkang Feb 17, 2015
 */
public class _055_Jump_Game {

	public static boolean canJump(int[] A) {
		if (A == null || A.length == 0 || A.length == 1) {
			return true;
		}

		int maxLen = A[0];

		int offset = 0;

		while (offset < A.length) {
			if (A[offset] != 0) {
				maxLen = Math.max(maxLen - 1, A[offset]);
			} else {
				maxLen--;
				if (maxLen <= 0) {
					if (offset == A.length - 1) {
						return true;
					}
					return false;
				}
			}
			offset++;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(canJump(new int[] { 2, 2, 0, 0, 0 }));
		System.out.println(canJump(new int[] { 3, 2, 1, 0, 4 }));
	}
}