package peter;

public class _014_Longest_Common_Prefix {

	public String longestCommonPrefix(String[] strs) {
		StringBuilder sb = new StringBuilder();
		if (strs == null || strs.length == 0) {
			return "";
		}

		try {
			for (int i = 0; i < strs[0].length(); i++) {
				char currentChar = strs[0].charAt(i);
				for (int j = 0; j < strs.length; j++) {
					if (currentChar == strs[j].charAt(i)) {
						continue;
					}
					return sb.toString();
				}
				sb.append(currentChar);
			}
		} catch (Exception e) {
			return sb.toString();
		}
		return sb.toString();
	}

}