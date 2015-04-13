package peter;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors. What is the minimum candies you must give?
 * 
 * @author peter
 * 
 */
public class _135_Candy {

	public static int candy(int[] ratings) {
		if (ratings == null) {
			return 0;
		} else if (ratings.length == 1) {
			return 1;
		}

		boolean isAscending = true;
		boolean isFirst = true;

		int f0 = 1;
		int f1 = 1;
		if (ratings[1] < ratings[0]) {
			f0 = 2;
			isAscending = false;
		} else if (ratings[1] > ratings[0]) {
			f1 = 2;
		}

		// 3,2,1,4,5,3,2
		int totalCandy = f0 + f1;

		int keyPoint = 0;

		for (int i = 2; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				if (!isAscending && !isFirst) {
					totalCandy -= (f1 - 1) * (i - 1 - keyPoint);
					f1 = 1;
				}

				isAscending = true;
				int tmp = f1;
				f0 = f1;
				f1 = tmp + 1;
				totalCandy += f1;
			} else if (ratings[i] < ratings[i - 1]) {
				if (isAscending) {
					keyPoint = i - 1;
					isAscending = false;
					isFirst = false;
				}

				if (f1 == 1) {
					totalCandy += i - keyPoint;
					f0 = f1 + 1;
					f1 = 1;
					totalCandy += 1;
				} else {
					int tmp = f1;
					f0 = f1;
					f1 = tmp - 1;
					totalCandy += f1;
				}
			} else {
				if (!isAscending) {
					totalCandy -= (f1 - 1) * (i - 1 - keyPoint);
					f1 = 1;
				}
				isAscending = false;
				keyPoint = i;
				f0 = f1;
				f1 = 1;
				totalCandy += 1;
			}
		}

		if (!isAscending) {
			totalCandy -= (f1 - 1) * (ratings.length - 1 - keyPoint);
		}
		return totalCandy;
	}

	public static void main(String[] args) {
		System.out.println(candy(new int[] { 1, 2, 4, 4, 3 }));
		System.out.println(candy(new int[] { 4, 2, 3, 4, 1 }));
		System.out.println(candy(new int[] { 1, 1, 1, 1, 1, 1 }));
		System.out.println(candy(new int[] { 3, 2, 1, 4, 5, 3, 2 }));
		System.out.println(candy(new int[] { 3, 2, 1, 9, 5, 2, 3, 1, 2, 3, 8,
				4, 1, 1 }));

	}
}