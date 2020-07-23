/**
 * @author wsq
 * @Date 2020/7/22
 * 	旋转数组的最小数字
 * 	把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

	示例 1：

	输入：[3,4,5,1,2]
	输出：1
	示例 2：
	
	输入：[2,2,2,0,1]
	输出：0
	
	链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 */
package code.wsq;

public class RotateArray {
    public int minArray(int[] numbers) {
        int ans = numbers[0];
        for(int i = 1; i < numbers.length; ++i){
            if(numbers[i] < ans){
                return numbers[i];
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
    	RotateArray ra = new RotateArray();
    	int[] numbers = {3,4,5,1,2};
    	int ans = ra.minArray(numbers);
    	System.out.println(ans);
	}
}
