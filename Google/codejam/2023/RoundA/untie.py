def count_min(c):
    count = 0
    i = 1
    while (i < len(c)):
        if c[i] == c[i-1] :
            count += 1
            i+=1
        i+= 1
    if (i == len(c) and c[0] == c[len(c)-1]) :
        count += 1
    return count


t = int(input())
for case in range(1, t+1):
    c = input()
    cr = c[1:] + c[0]
    count = min(count_min(c), count_min(cr))
    print("Case #" + str(case) + ": " + str(count))