package peter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by ylkang on 9/28/15.
 */
public class _282_Expression_Add_Operators {

    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if (num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }

    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval)
                rst.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur, cur);

                helper(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);

                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new _282_Expression_Add_Operators().addOperators("123", 6));
        System.out.println(new _282_Expression_Add_Operators().addOperators("232", 8));
        System.out.println(new _282_Expression_Add_Operators().addOperators("105", 5));
        System.out.println(new _282_Expression_Add_Operators().addOperators("00", 0));
        System.out.println(new _282_Expression_Add_Operators().addOperators("3456237490", 9191));
    }
}
