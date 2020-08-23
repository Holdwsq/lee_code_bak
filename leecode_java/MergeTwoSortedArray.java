/***
 * 88. 合并两个有序数组
 * @author wsq
 * @date 2020/8/15
	 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
	
	说明:
	初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
	你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
	
	示例:
	输入:
	nums1 = [1,2,3,0,0,0], m = 3
	nums2 = [2,5,6],       n = 3
	输出: [1,2,2,3,5,6]
	
	链接：https://leetcode-cn.com/problems/merge-sorted-array
 */
package code.wsq.notsubmit;

import java.util.Arrays;

public class MergeTwoSortedArray {
	/**
	 * 	先合并再排序
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	 public void merge(int[] nums1, int m, int[] nums2, int n) {
		 int i = m;
		 for(int j = 0; j < n; ++j) {
			 nums1[i++] = nums2[j];
		 }
		 Arrays.sort(nums1);
	 }
	 /**
	  *	采用双后指针的方式，从数组的后端移动，可以避免额外空间的浪费
	  * @param nums1
	  * @param m
	  * @param nums2
	  * @param n
	  */
	 public void merge1(int[] nums1, int m, int[] nums2, int n) {
		 int p1 = m - 1;
		 int p2 = n - 1;
		 int p = m + n - 1;
		 
		 while((p1 >= 0) && (p2 >= 0)) {
			 nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
		 }
		 
		 System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
	 }
	 
	 public static void main(String[] args) {
		 int[] nums1 = {1, 2, 3, 0, 0, 0};
		 int[] nums2 = {2, 5, 6};
		 int m = 3;
		 int n = 3;
		 
		 MergeTwoSortedArray ma = new MergeTwoSortedArray();
		 ma.merge1(nums1, m, nums2, n);
		 for(int i = 0; i < m+n; ++i) {
			 System.out.println("nums1[" + i + "] = " + nums1[i]);
		 }
	}
}
