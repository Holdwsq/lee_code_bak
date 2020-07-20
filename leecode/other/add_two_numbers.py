"""
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

链接：https://leetcode-cn.com/problems/add-two-numbers
"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        added_num = 0
        l = ListNode(None)
        tmp_l = l
        while l1 is not None and l2 is not None:
            n1 = l1.val
            n2 = l2.val
            total_n = n1 + n2 + added_num
            # 除数
            added_num = total_n // 10
            tmp_node = ListNode(total_n % 10)
            tmp_node.next = None
            tmp_l.next = tmp_node
            tmp_l = tmp_node

            l1 = l1.next
            l2 = l2.next

        if l1 is not None or l2 is not None:
            t_l = l1 if l1 is not None else l2
            tmp_l.next = t_l
            tmp_l = tmp_l.next

            while tmp_l is not None:
                total_n = tmp_l.val + added_num
                tmp_l.val = total_n % 10
                added_num = total_n // 10
                if tmp_l.next is None:
                    break
                else:
                    tmp_l = tmp_l.next

        if added_num != 0:
            tmp_node = ListNode(added_num)
            tmp_node.next = None
            tmp_l.next = tmp_node

        return l.next


if __name__ == "__main__":
    node1 = ListNode(1)
    # node2 = ListNode(8)
    # node3 = ListNode(3)
    # node1.next = node2
    # node2.next = node3
    node1.next = None

    node4 = ListNode(9)
    node5 = ListNode(9)
    # node5 = ListNode(6)
    # node6 = ListNode(4)
    node4.next = node5
    # node5.next = node6
    node5.next = None

    s = Solution()
    numbers = s.addTwoNumbers(node1, node4)
    print(numbers)
