package peter;

/**
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * Note: The solution is guaranteed to be unique.
 * 
 * @author ylkang Feb 26, 2015
 */
public class _134_Gas_Station {

	public static int canCompleteCircuit_slow(int[] gas, int[] cost) {
		if (gas == null || gas.length == 0) {
			return -1;
		}

		for (int i = 0; i < gas.length; i++) {
			int start = i;
			int rest = gas[i];
			boolean isOk = true;
			do {
				rest = rest - cost[start];
				if (rest < 0) {
					isOk = false;
					break;
				}
				start = (start + 1) % gas.length;
				rest = rest + gas[start];
			} while (start != i);
			if (isOk) {
				return i;
			}
		}

		return -1;
	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || gas.length == 0) {
			return -1;
		}

		int curStart = 0;
		int offset = 0;
		int len = 0;

		int left = 0;

		while (len != gas.length) {
			left += gas[curStart] - cost[curStart];
			curStart++;
			len++;
			if (left < 0) {
				while (left < 0 && len < gas.length) {
					offset = (offset + gas.length - 1) % gas.length;
					len++;
					left += gas[offset] - cost[offset];
				}
				if (len == gas.length) {
					if (left < 0) {
						return -1;
					} else {
						return offset;
					}
				}
			}
		}

		return offset;

	}

	public static void main(String[] args) {

		System.out.println(canCompleteCircuit(new int[] { 1, 5 }, new int[] {
				2, 4 }));
		System.out.println(canCompleteCircuit(new int[] { 0, 0, 0, 0, 11 },
				new int[] { 1, 1, 2, 3, 4 }));
	}
}