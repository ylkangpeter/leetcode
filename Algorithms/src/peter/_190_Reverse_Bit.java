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

	private static int[] mask = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024,
			2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288,
			1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864,
			134217728, 268435456, 536870912, 1073741824, -2147483648 };

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
		System.out
				.println("00" + Integer.toBinaryString(reverseBits(417168415)));
		System.out.println(Integer.toBinaryString(417168415));

		// System.out.println(reverseBits(Integer.MIN_VALUE));
	}
}
