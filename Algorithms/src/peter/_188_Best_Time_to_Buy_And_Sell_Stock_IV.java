package peter;

import java.util.ArrayList;
import java.util.List;

public class _188_Best_Time_to_Buy_And_Sell_Stock_IV {
	public int maxProfix(int k, int[] prices) {
		if (prices.length <= 1 || k == 0) {
			return 0;
		}
		if (k >= prices.length / 2) {
			int max = 0;
			for (int i = 0; i < prices.length - 1; i++) {
				max += Math.max(prices[i + 1] - prices[i], 0);
			}
			return max;
		}

		int[] release = new int[k + 1];
		int[] hold = new int[k + 1];

		for (int i = 0; i < release.length; i++) {
			release[i] = 0;
			hold[i] = Integer.MIN_VALUE;
		}

		for (int i = 0; i < prices.length; i++) {
			for (int j = k; j > 0; j--) {
				release[j] = Math.max(release[j], hold[j] + prices[i]);
				hold[j] = Math.max(hold[j], release[j - 1] - prices[i]);
			}
		}
		return release[k];
	}

	public int maxProfix_slow(int k, int[] prices) {

		if (prices.length <= 1 || k == 0)
			return 0;
		List<Integer> lowPrices = new ArrayList<Integer>();
		List<Integer> highPrices = new ArrayList<Integer>();
		for (int i = 0; i < prices.length; ++i) {
			if ((i == 0 && prices[i] < prices[i + 1])
					|| (i > 0 && i < prices.length - 1
							&& prices[i] <= prices[i - 1] && prices[i + 1] > prices[i])) {
				if (lowPrices.size() == highPrices.size())
					lowPrices.add(prices[i]);
			}
			if ((i == prices.length - 1 && prices[i] >= prices[i - 1])
					|| (i > 0 && i < prices.length - 1
							&& prices[i] >= prices[i - 1] && prices[i + 1] < prices[i])) {
				if (lowPrices.size() > highPrices.size())
					highPrices.add(prices[i]);
			}
		}
		int profit = 0;
		for (int i = 0; i < lowPrices.size(); ++i)
			profit += highPrices.get(i) - lowPrices.get(i);
		if (k >= lowPrices.size() || profit == 0)
			return profit;
		int count = lowPrices.size() - k;
		// either delete some transactions or combine neighbor transactions
		while (count > 0) {
			int delLoss = Integer.MAX_VALUE;
			int delIndex = 0;

			int comLoss = Integer.MAX_VALUE;
			Pair comPair = new Pair();
			for (int i = 0; i < lowPrices.size(); ++i) {
				if (lowPrices.get(i) != -1
						&& highPrices.get(i) - lowPrices.get(i) < delLoss) {
					delIndex = i;
					delLoss = highPrices.get(i) - lowPrices.get(i);
				}
				if (lowPrices.get(i) != -1) {
					int j = i + 1;
					while (j < lowPrices.size() && lowPrices.get(j) == -1)
						++j;
					if (j < lowPrices.size()
							&& (highPrices.get(i) - lowPrices.get(j) < comLoss)) {
						comLoss = highPrices.get(i) - lowPrices.get(j);
						comPair.first = i;
						comPair.second = j;
					}
				}
			}
			if (delLoss <= comLoss) {
				lowPrices.set(delIndex, -1);
				profit -= delLoss;
			} else {
				highPrices.set(comPair.first, highPrices.get(comPair.second));
				lowPrices.set(comPair.second, -1);
				profit -= comLoss;
			}
			--count;
		}
		return profit;
	}

	private static class Pair {
		int first;
		int second;
	}
}
