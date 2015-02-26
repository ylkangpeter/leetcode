package peter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 * 
 * For example,
 * 
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * 
 * Return: ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 * @author ylkang Feb 25, 2015
 */
public class _187_Repeated_DNA_Sequences {

	public static List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		if (s == null || s.length() <= 10) {
			return result;
		}

		for (int i = 0; i < s.length() - 9; i++) {
			String tmp = s.substring(i, i + 10);
			Integer counter = map.get(tmp);
			if (counter == null) {
				counter = 1;
				map.put(tmp, counter);
			} else if (counter == 1) {
				counter = 2;
				map.put(tmp, counter);
				result.add(tmp);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
	}
}
