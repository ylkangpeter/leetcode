package peter;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _121_Best_Time_to_Buy_and_Sell_Stock {

	public int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}

		int total = 0;
		int low = 0;
		int i = 0;
		for (; i < prices.length - 1; i++) {
			if (prices[i + 1] > prices[i]) {
				low = prices[i];
				break;
			}
		}
		i++;
		for (; i < prices.length; i++) {
			if (prices[i] < low) {
				low = prices[i];
			} else if (prices[i] - low > total) {
				total = prices[i] - low;

			}
		}

		return total;

	}

}