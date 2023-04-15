def couvreLeft(x, r, last):
    return x - r <= last

def couvreRight(x, r, last):
    return x + r >= last

t = int(input())
for c in range(1, t+1):
    m, r, n = [int(k) for k in input().split()]
    x = [int(k) for k in input().split()]
    last = 0
    count = 0
    start = 0
    i = start
    while(i < len(x) and last < m):
        while(i < len(x) and couvreLeft(x[i], r, last)):
            i += 1
        if (i > start):
            last = x[i-1] + r
            count += 1
            start = i
        else :
            # i == 0 jamais dkhlna boucle IMPSSIBLE
            break
    if (last >= m) :
        print("Case #" + str(c) + ": " + str(count))
    else:
        print("Case #" + str(c) + ": IMPOSSIBLE")