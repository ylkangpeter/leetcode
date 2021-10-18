package peter;

/**
 * 给你一个有效的 IPv4 地址?address，返回这个 IP 地址的无效化版本。
 * <p>
 * 所谓无效化?IP 地址，其实就是用?"[.]"?代替了每个 "."。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 给出的?address?是一个有效的 IPv4 地址
 * <p>
 * https://leetcode-cn.com/problems/defanging-an-ip-address
 */
public class _1108_Defanging_an_IP_Address {

    public String defangIPaddr(String address) {
        StringBuffer sb = new StringBuffer();
        for (char c : address.toCharArray()) {
            if (c == '.') {
                sb.append("[.]");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}