import sys

read = sys.stdin.readline
L = int(read())
N = list(read().rstrip())
sum = 0
for i in N:
    sum += int(i)
print(sum)
