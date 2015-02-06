package peter;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 * 
 * @author ylkang Feb 5, 2015
 */
public class _122_Best_Time_to_Buy_and_Sell_Stock_II {

	public int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}

		int total = 0;
		int pre = 0;
		int low = 0;
		boolean isAsending = false;
		int i = 0;
		for (; i < prices.length - 1; i++) {
			if (prices[i + 1] > prices[i]) {
				low = prices[i];
				pre = prices[i];
				isAsending = true;
				break;
			}
		}
		i++;
		if (isAsending) {
			for (; i < prices.length; i++) {
				if (prices[i] >= pre) {
					if (!isAsending) {
						isAsending = true;
						low = pre;
					}
				} else {
					if (isAsending) {
						isAsending = false;
						total += pre - low;
						low = prices[i];
					}
				}
				pre = prices[i];
			}
			if (isAsending) {
				total += prices[prices.length - 1] - low;
			}
			return total;
		}
		return 0;
	}

}
