class Solution:
    def canJump(self, nums: List[int]) -> bool:
        jum=0
        for i in range(len(nums)):
            if jum<i:
                return False
            jum=max(jum,i+nums[i])
        return True
    