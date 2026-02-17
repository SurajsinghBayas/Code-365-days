class Solution:
    def readBinaryWatch(self, turnedOn: int) -> List[str]:

        result = []
    
        for hour in range(12):
            for minute in range(60):
            # count number of 1s in binary
                if bin(hour).count('1') + bin(minute).count('1') == turnedOn:
                # format minute to always 2 digits
                    result.append(f"{hour}:{minute:02d}")
    
        return result
