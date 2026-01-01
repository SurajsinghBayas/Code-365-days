
def isAnagram(s: str, t: str):
    s = s.lower()
    t = t.lower()
    sort1 = sorted(s)
    sort2 = sorted(t)

    if sort1 == sort2:
        return True
    else:
        return False


print(isAnagram(s="anagram", t="nagaram"))
        


