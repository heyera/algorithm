import sys

read = sys.stdin.readline
n = int(read().rstrip())
x = int(0)
t = int(1)
while (1):
    t += (6 * x)
    x += 1
    if t >= n:
        break
print(x)
