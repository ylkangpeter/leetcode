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
		int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
		int release1 = 0, release2 = 0;
		for (int i : prices) { // Assume we only have 0 money at first
			release2 = Math.max(release2, hold2 + i); // The maximum if we've
														// just sold 2nd stock
														// so far.
			hold2 = Math.max(hold2, release1 - i); // The maximum if we've just
													// buy 2nd stock so far.
			release1 = Math.max(release1, hold1 + i); // The maximum if we've
														// just sold 1nd stock
														// so far.
			hold1 = Math.max(hold1, -i); // The maximum if we've just buy 1st
											// stock so far.
		}
		return release2; // /Since release1 is initiated as 0, so release2 will
							// always higher than release1.
	}
}