
class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        curr_count=0
        count=0
        for i in range(len(nums)):
            if nums[i]==1:
                count+=1
                curr_count=max(curr_count,count)
            else:
                count=0
        return curr_count
