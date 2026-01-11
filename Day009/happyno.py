class Solution:
    def isHappy(self, n: int) -> bool:
        seen = set()

        while n != 1:
            if n in seen:
                return False
            seen.add(n)

            s = 0
            while n > 0:
                d = n % 10
                s += d * d
                n //= 10

            n = s

        return True
