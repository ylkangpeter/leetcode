package peter;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * <pre>
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 * 
 * </pre>
 * 
 * @author ylkang May 11, 2015
 */
public class _071_Simplify_Path {

	public String simplifyPath(String path) {
		if (path == null || path.trim().equals("")) {
			return "";
		}

		Stack<String> stack = new Stack<String>();

		StringBuilder file = new StringBuilder();
		for (int i = 1; i < path.length(); i++) {
			if (path.charAt(i) == '/') {
				if (file.length() == 0) {
					continue;
				} else {
					if (file.toString().equals("..")) {
						if (!stack.isEmpty()) {
							stack.pop();
						}
					} else if (file.toString().equals(".")) {
						file = new StringBuilder();
					} else {
						stack.push(file.toString());
					}
					file = new StringBuilder();
				}
			} else {
				file.append(path.charAt(i));
			}
		}

		if (file.toString().equals("..")) {
			if (!stack.isEmpty()) {
				stack.pop();
			}
			file = new StringBuilder();
		}

		StringBuilder out = new StringBuilder();
		for (String str : stack) {
			out.append("/");
			out.append(str);
		}
		if (file.length() > 0 && !file.toString().equals(".")) {
			out.append("/");
			out.append(file);
		}

		if (out.length() == 0) {
			return "/";
		}
		return out.toString();

	}

	public static void main(String[] args) {
		System.out.println(new _071_Simplify_Path().simplifyPath("/a/.."));
		System.out.println(new _071_Simplify_Path().simplifyPath("/.."));
		System.out.println(new _071_Simplify_Path().simplifyPath("/."));
		System.out.println(new _071_Simplify_Path().simplifyPath("/home/./bar/"));
		System.out.println(new _071_Simplify_Path().simplifyPath("/home"));
		System.out.println(new _071_Simplify_Path().simplifyPath("/../"));
		System.out.println(new _071_Simplify_Path()
				.simplifyPath("/a/./b/../../c/"));

	}
}