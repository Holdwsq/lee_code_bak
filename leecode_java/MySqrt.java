/**
 * 69. x 的平方根
 * @author wsq
 * @date 2020/8/18
	实现 int sqrt(int x) 函数。
	计算并返回 x 的平方根，其中 x 是非负整数。
	由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
	
	示例 1:
	输入: 4
	输出: 2
	示例 2:

	输入: 8
	输出: 2
	说明: 8 的平方根是 2.82842..., 
	     由于返回类型是整数，小数部分将被舍去。
	
	链接：https://leetcode-cn.com/problems/sqrtx
 */
package code.wsq.notsubmit;

public class MySqrt {
	/**
	 *	二分查找思想，与二分查找不同的地方在于使用ans变量保留上次满足条件的值
	 * @param x
	 * @return
	 */
    public int mySqrt(int x) {
    	int start = 0;
    	int end = x;
    	int ans = -1;
    	
    	while(start <= end) {
    		int mid = (start + end) >> 1;
    		if((long)mid * mid <= x) {
    			ans = mid;
    			start = mid + 1;
    		}else {
    			end = mid - 1;
    		}
    	}
    	return ans;
    }
    
    public static void main(String[] args) {
		int x = 0;
		MySqrt ms = new MySqrt();
		int ans = ms.mySqrt(x);
		System.out.println(ans);
	}
}
