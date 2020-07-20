"""
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2
示例 2:

输入: [1,3,5,6], 2
输出: 1
示例 3:

输入: [1,3,5,6], 7
输出: 4

链接：https://leetcode-cn.com/problems/search-insert-position
"""
from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        n = len(nums)
        left = 0
        right = n - 1
        ans = n

        while left <= right:
            mid = ((right - left) >> 1) + left
            if target <= nums[mid]:
                ans = mid
                right = mid - 1
            elif target > nums[mid]:
                left = mid + 1

        return ans


if __name__ == "__main__":
    nums = [1, 3, 5, 6]
    target = 5
    s = Solution()
    pos = s.searchInsert(nums, target)
    print(pos)
