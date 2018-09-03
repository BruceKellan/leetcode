package top.brucekellan.leetcode;

/**
 * 50. Pow(x, n)
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * Example 1:
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * @Author: 37
 * @Date: Created at 21:34 2018/9/3
 */
public class Powxn {

    public double myPow(double x, int n) {
        //如果是n负数，要避免n=<span style="font-family: Arial, Helvetica, sans-serif;">-2147483648</span><span style="font-family: Arial, Helvetica, sans-serif;">溢出</span>
        int m = n < 0 ? -n - 1 : n;
        double p = 1;
        for (double q = x; m > 0; m /= 2) {
            //一旦该位为1，那么将q乘入p中
            if ((m & 1) != 0) {
                p *= q;
            }
            //m每次除2，q就要变为平方
            q *= q;
        }
        return n < 0 ? 1 / p / x : p;

    }

}
