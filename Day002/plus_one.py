class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        result=0
        for num in digits:
            result=result*10+num
        result=result+1
        news=[]
        while result>0:
            digit=result%10
            news.append(digit)
            result=result//10
        news.reverse()
        return news


       