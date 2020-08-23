/**
 * 83. 删除排序链表中的重复元素
 * @author wsq
 * @date 2020/8/17
	 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

	示例 1:
	输入: 1->1->2
	输出: 1->2

	示例 2:
	输入: 1->1->2->3->3
	输出: 1->2->3
	
	链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 */
package code.wsq.notsubmit;

//  Definition for singly-linked list.
class ListNode {
	int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
 
public class RemovesDuplicateElements {
	/**
	 *	链表的基础操作，采用双指针的形式
	 *	p指针指向当前节点
	 *	q指针去寻找与当前节点val不同的节点
	 *	最后使得p.next = q
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) {
			return head;
		}
		ListNode p = head;
		ListNode q = head.next;
		while(q != null) {
			if(q.val != p.val) {
				p.next = q;
				p = p.next;
			}
			q = q.next;
		}
		p.next = null;
		return head;
	}
	 
}
