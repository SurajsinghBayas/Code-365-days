class Solution:
    def repeatedNTimes(self, nums: List[int]) -> int:
        for i in range((len(nums)-1)):
            for j in range(i+1,len(nums)):
                if nums[i]==nums[j]:
                    return nums[i]