from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            n1 = target - nums[i]
            try:
                n2 = nums.index(n1, i+1)
                if n2:
                    return [i, n2]
            except ValueError:
                continue

    def twoSum2(self, nums: List[int], target: int) -> List[int]:
        tmp_map = {}
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in tmp_map.keys():
                return [tmp_map[complement], i]
            tmp_map[nums[i]] = i
        return


if __name__ == "__main__":
    nums = [3, 3]
    s = Solution()
    result = s.twoSum2(nums, 6)
    print(result)
