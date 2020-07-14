"""
给定两个数组，编写一个函数来计算它们的交集。
示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]
示例 2:

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]
说明：
1. 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
2. 我们可以不考虑输出结果的顺序。
"""
from typing import List
import collections

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # tmp_dict = dict()
        # result = []
        # # tmp_num = nums1 if len(nums1) < len(nums2) else nums2
        # for n in nums1:
        #     if n in tmp_dict.keys():
        #         tmp_dict[n] += 1
        #     else:
        #         tmp_dict[n] = 1
        # for n in nums2:
        #     if n in tmp_dict.keys() and tmp_dict[n] > 0:
        #         result.append(n)
        #         tmp_dict[n] -= 1
        # return result
        num1 = collections.Counter(nums1)
        num2 = collections.Counter(nums2)
        num = num1 & num2
        for s in num.elements():
            print(s)

if __name__ == "__main__":
    s = Solution()
    intersection = s.intersect([1, 2, 2, 1], [2, 2])