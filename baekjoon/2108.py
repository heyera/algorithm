import sys

read = sys.stdin.readline
n = int(read().rstrip())
num = []
for _ in range(n):
    num.append(int(read().rstrip()))
plus = avg = mid = mode = reach = m = M = 0
for i in range(n):
    plus += num[i]
    if i == 0:
        m = M = num[0]
    else:
        if num[i] > M:
            M = num[i]
        if num[i] < m:
            m = num[i]
