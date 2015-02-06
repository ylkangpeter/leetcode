package peter;

import java.util.ArrayList;
import java.util.List;

public class _046_Permutations {

	public List<List<Integer>> permute(int[] num) {
		if (num == null)
			return null;

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		// Set<List<Integer>> set = new HashSet<List<Integer>>();

		perm(list, 0, num.length - 1, num);
		// list.addAll(set);
		return list;
	}

	private void perm(List<List<Integer>> list, int start, int end, int[] num) {
		if (start == end) {
			List<Integer> l = new ArrayList<Integer>();
			for (int j = 0; j < num.length; j++) {
				l.add(num[j]);
			}
			list.add(l);
			return;
		}

		for (int i = start; i <= end; i++) {
			int tmp = num[start];
			num[start] = num[i];
			num[i] = tmp;

			perm(list, start + 1, end, num);

			num[i] = num[start];
			num[start] = tmp;

		}
	}

}