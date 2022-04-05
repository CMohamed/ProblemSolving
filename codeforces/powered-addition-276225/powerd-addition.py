def vp2(n):
    count = 0
    while n >= 1 :
        n /= 2
        count += 1
    return count
 
 
t = int(input())
for k in range(t):
    n = int(input())
    a = [int(k) for k in input().split()]
    ans = 0
    for i in range(1, n):
        d = a[i-1] - a[i]
        if d>0 :
            l = vp2(d)
            a[i] = a[i] + d
            ans = max(ans, l)
    print(ans)