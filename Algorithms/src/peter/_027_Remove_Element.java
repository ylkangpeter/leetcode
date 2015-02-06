package peter;

public class _027_Remove_Element {

	public int removeElement(int[] A, int elem) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int inx = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == elem) {
				continue;
			}
			A[inx] = A[i];
			inx++;
		}
		return inx;
	}

}