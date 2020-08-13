/***
 *	二叉树展开为链表
 * @author wsq
 * @date 2020/8/2
 * 	给定一个二叉树，原地将它展开为一个单链表。
	例如，给定二叉树
	
	    1
	   / \
	  2   5
	 / \   \
	3   4   6
	将其展开为：
	
	1
	 \
	  2
	   \
	    3
	     \
	      4
	       \
	        5
	         \
	          6
	链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 */
package code.wsq.notsubmit;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class TreeNode{
	Integer val;
	TreeNode left;
	TreeNode right;
	public TreeNode(Integer val) {
		// TODO Auto-generated constructor stub
		this.val = val;
	}
	public TreeNode(Integer val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class FlattenTheBinaryTree {
	/**
	 * 	将二叉树展平为链表的形式，可以思考为以下几步走：
	 * 1. 展平左子树
	 * 2. 展平右子树
	 * 3. 根节点的右子树指向左子树的根节点
	 * 4. 左子树的展开的最后一个右节点指向展开的右子树
	 * 5. 根节点的左子树指向null
	 * @param root
	 */
	public void flatten(TreeNode root) {
		if(root == null || (root.left == null && root.right == null)) {
			return;
		}
		
		TreeNode left = root.left;
		flatten(left);
		
		TreeNode right = root.right;
		flatten(right);
		
		if(left != null) {
			root.right = left;
			while(left.right != null) {
				left = left.right;
			}
			left.right = right;
		}else {
			root.right = right;
		}
		root.left = null;
	}
	/**
	 *	借助栈结构实现树的中序遍历
	 * @param root
	 */
	public void flatten2(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		ArrayList<TreeNode> list = new ArrayList<>();	
		
		TreeNode node = root;
		while(node != null || !stack.isEmpty()) {
			while(node != null) {
				list.add(node);
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			node = node.right;
		}
		
		int size = list.size();
		for(int i = 1; i < size; ++i) {
			TreeNode pre = list.get(i-1), curr = list.get(i);
			pre.left = null;
			pre.right = curr;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		
		root.left = node1;
		root.right = node4;
		
		node1.left = node2;
		node1.right = node3;
		
		node4.right = node5;
		
		FlattenTheBinaryTree fbt = new FlattenTheBinaryTree();
		fbt.flatten2(root);
		TreeNode node = root;
		while(node != null) {
			System.out.println(node.val);
			node = node.right;
		}
	}
}
