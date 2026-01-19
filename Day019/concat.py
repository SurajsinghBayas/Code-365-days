class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        result=[]
        for i in range(2):
            for j in range(len(nums)):
                result.append(nums[j])

        return result