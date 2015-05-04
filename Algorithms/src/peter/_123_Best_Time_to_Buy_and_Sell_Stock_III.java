package peter;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * @author ylkang Apr 15, 2015
 */
public class _123_Best_Time_to_Buy_and_Sell_Stock_III {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int sellTimes = 2;

		int[][] maxArray = new int[sellTimes][prices.length];

		int low = prices[0];
		int max = 0;
		for (int k = 0; k < sellTimes; k++) {
			for (int i = 1; i < prices.length; i++) {
				if (prices[i] < low) {
					low = prices[i];
				} else {
					maxArray[i] = Math.max(max, prices[i] - low);
					max = Math.max(max, maxArray[i]);
				}
			}
		}

		// for()
	}
}