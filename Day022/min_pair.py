class Solution:
    def minimumPairRemoval(self, nums: List[int]) -> int:
        count = 0

        while not self.is_non_decreasing(nums):
            min_sum = float('inf')
            idx = 0

            # find leftmost adjacent pair with minimum sum
            for i in range(len(nums) - 1):
                s = nums[i] + nums[i + 1]
                if s < min_sum:
                    min_sum = s
                    idx = i

            # merge the chosen pair
            nums[idx] = nums[idx] + nums[idx + 1]
            nums.pop(idx + 1)
            count += 1

        return count

    def is_non_decreasing(self, nums):
        for i in range(len(nums) - 1):
            if nums[i] > nums[i + 1]:
                return False
        return True
