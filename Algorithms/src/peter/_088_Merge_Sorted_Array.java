package peter;

public class _088_Merge_Sorted_Array {

	private boolean isAsending = true;

	/*
	 * check 1st small number in A,(say it's kth) then copy all following number
	 * from A[k+1]-A[m] to A[m+n-k]-A[m+n]
	 */
	public void merge(int A[], int m, int B[], int n) {

		if (m == 0) {
			System.arraycopy(B, 0, A, 0, n);
			return;
		} else if (n == 0) {
			return;
		}
		if (m > 1 && n > 1) {
			for (int i = 0; i < m; i++) {
				if (A[i + 1] == A[i])
					continue;
				if (A[i + 1] > A[i]) {
					isAsending = true;
				}
				break;
			}
		}

		int k = 0;
		for (k = 0; k < m; k++) {
			if (isAsending) {
				if (A[k] > B[0])
					break;
			} else {
				if (A[k] < B[0])
					break;
			}
		}

		// copy
		for (int i = m - k - 1; i >= 0; i--) {
			A[k + n + i] = A[i + k];
		}

		// fill
		int a_right_bound = m + n;
		int a_offset = k + n;
		int b_offset = 0;
		int insertInx = k;

		while (a_offset < a_right_bound || b_offset < n) {
			if (a_offset == a_right_bound) {
				System.arraycopy(B, b_offset, A, insertInx, n - b_offset);
				break;
			} else if (b_offset == n) {
				System.arraycopy(A, a_offset, A, insertInx, a_right_bound
						- a_offset);
				break;
			}

			int current_A = A[a_offset];
			int current_B = B[b_offset];
			if (isAsending) {
				if (current_A <= current_B) {
					A[insertInx] = current_A;
					a_offset++;
				} else {
					A[insertInx] = current_B;
					b_offset++;
				}
			} else {
				if (current_A <= current_B) {
					A[insertInx] = current_B;
					b_offset++;
				} else {
					A[insertInx] = current_A;
					a_offset++;
				}
			}
			insertInx++;
		}

	}

}