/**
 * 109. 有序链表转换二叉搜索树
 *	@author wsq
 *  @date 2020/8/18
	给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
	本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

	示例:
	给定的有序链表： [-10, -3, 0, 5, 9],
	一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
	      0
	     / \
	   -3   9
	   /   /
	 -10  5
	
	链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 */
package code.wsq.notsubmit;

import java.util.ArrayList;

/*//  Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}*/


/*  class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
  TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
  TreeNode right) { this.val = val; this.left = left; this.right = right; } }*/
 

public class SortedListToBST {
	/**
	 *	1.将链表转为有序的数组顺序存储
	 *	2.使用深度优先遍历，建立树节点
	 *	3.每个子树的根节点为索引start到end的中间位置
	 *	4.类似二分查找的思想
	 * @param head
	 * @return
	 */
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode p = head;
       
        while(p != null) {
        	list.add(p.val);
        	p = p.next;
        }
        int start = 0;
        int end = list.size() - 1;
        TreeNode root = build_tree(list, start, end);
        return root;
    }

	private TreeNode build_tree(ArrayList<Integer> list, int start, int end) {
		// TODO Auto-generated method stub
		if(start > end) {
			return null;
		}
		
		if(start == end) {
			return new TreeNode(list.get(start));
		}
		
		int mid = (start + end) % 2 != 0 ? (start + end) / 2 + 1 : (start + end) / 2;
		TreeNode leftNode = build_tree(list, start, mid - 1);
		TreeNode rightNode = build_tree(list, mid + 1, end);
		TreeNode root = new TreeNode(list.get(mid));
		root.left = leftNode;
		root.right = rightNode;
		
		return root;
	}
}
