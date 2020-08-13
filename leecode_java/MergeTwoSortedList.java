/**
 * 21. 合并两个有序链表
 * @author wsq
 * @date 2020/8/12
	将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
	
	示例：
	输入：1->2->4, 1->3->4
	输出：1->1->2->3->4->4
	
	链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 */
package code.wsq.notsubmit;

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val;}
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class MergeTwoSortedList {
	/**
	 *	常规迭代方法
	 *	构建一个root节点，一个标记当前新列表位置的指针
	 * @param l1
	 * @param l2
	 * @return
	 */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode root = new ListNode();
        ListNode w = root;
        while(l1 != null && l2 != null) {
        	if(l1.val < l2.val) {
        		w.next = l1;
        		l1 = l1.next;
        	}else {
        		w.next = l2;
        		l2 = l2.next;
        	}
        	w = w.next;
        }
        if(l1 == null) {
        	w.next = l2;
        }else {
        	w.next = l1;
        }
        return root.next;
    }
}
