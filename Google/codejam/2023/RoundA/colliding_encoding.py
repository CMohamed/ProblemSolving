def encode(text, l):
    res = ""
    for x in text:
        res = res + l[ord(x)-ord('A')]
    return res

t = int(input())
for _ in range(1, t+1):
    words = set()
    l = input().split()
    n = int(input())
    for k in range(n):
        words.add(encode(input(), l))
    if (len(words) != n):
        print("Case #"+ str(_) +" YES")
    else :
        print("Case #"+ str(_) +" NO")