package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class T {

	public static void main(String[] args) {

		File f = new File("/Volumes/wd/git/leetcode/Algorithms/src/peter/");
		for (File ff : f.listFiles()) {
			String[] strs = ff.getName().split("_");
			int len = 3 - strs[1].length();
			if (len > 0) {
				String tmp = "_";
				for (int i = 0; i < len; i++) {
					tmp += "0";
				}
				tmp += strs[1] + "_";
				for (int i = 2; i < strs.length; i++) {
					tmp += strs[i] + "_";
				}
				tmp = tmp.substring(0, tmp.length() - 1);
				ff.renameTo(new File(
						"/Volumes/wd/git/leetcode/Algorithms/src/peter/" + tmp));
			}
		}
	}
}
