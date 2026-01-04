class Solution:
    def largestGoodInteger(self, num: str) -> str:
        ans=""
        for i in range(len(num)-2):
            if num[i]==num[i+1]==num[i+2]:
                now=num[i:i+3]
                if now>ans:
                    ans=now    

            
        return ans       