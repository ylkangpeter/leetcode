package peter;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * For example, given input 43261596 (represented in binary as
 * 00000010100101000001111010011100), return 964176192 (represented in binary as
 * 00111001011110000010100101000000).
 * 
 * Follow up: If this function is called many times, how would you optimize it?
 * 
 * Related problem: Reverse Integer
 * 
 * Credits:
 * 
 * @author ylkang Mar 9, 2015
 */
public class _190_Reverse_Bit {

	public static int reverseBits(int n) {

		for (int i = 0; i < 16; i++) {
			int right = (n >> i) & 1;
			int left = (n >> (31 - i)) & 1;
			if (right != left) {
				n ^= ((1 << i) | (1 << (31 - i)));
			}
			// if (i < 16) {
			// result |= ((mask[i] & n) << (31 - (i << 1)));
			// } else {
			// result |= ((mask[i] & n) >>> (31 - ((31 - i) << 1)));
			// }
		}
		return n;
	}

	public static void main(String[] args) {
		System.out.println("00"
				+ Integer.toBinaryString(reverseBits(417168415)));
		System.out.println(Integer.toBinaryString(417168415));

		// System.out.println(reverseBits(Integer.MIN_VALUE));
	}
}
