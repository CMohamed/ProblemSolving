def set_top_string(s):
    res = ""
    for x in s.keys():
        res = res + " " + x
    return res

t = int(input())
for c in range(1, 1+t):
    n = int(input())
    s = input().split()
    exist = {}
    exist[s[0]] = True
    i = 1
    while(i<len(s)):
        if (s[i-1] != s[i]):
            if exist.get(s[i], False):
                break
            else:
                exist[s[i]] = True
        i+=1
    if (i == len(s)):
        print("Case #" + str(c) + ":" + set_top_string(exist))
    else:
        print("Case #" + str(c) + ": IMPOSSIBLE")