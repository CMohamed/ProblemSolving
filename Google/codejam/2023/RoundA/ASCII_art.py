from math import *

def check(i, n):
    return i*(i+1)*13 <= n < (i+2)*(i+1)*13

def find_i(n, a, b):
    i = a
    while(i<=b):
        if check(i, n):
            return i
        i+=1
    return b

ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

t = int(input())
for c in range(1, t+1):
    n = int(input())
    b = int(sqrt(n/13 + 0.25) - 0.5)
    a = int(sqrt(n/13 + 0.25) - 1.5) + 1
    i = find_i(n, a, b)
    r = n - i*(i+1)*13
    x = ceil(r/(i+1))
    msg = ABC[x - 1]
    print("Case #"+ str(c) + ": " + msg)