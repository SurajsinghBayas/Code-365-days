class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n <= 0:
            return False

        i = 0
        while (1 << i) <= n:
            if n == (1 << i):
                return True
            i += 1

        return False