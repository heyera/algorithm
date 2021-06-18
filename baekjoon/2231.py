import sys

read = sys.stdin.readline
n = read().rstrip()
x = int(1)
s = int(0)
while (1):
    if x > int(n):
        print(0)
        break
    for i in str(x):
        s += int(i)
    s += x
    if int(n) == s:
        print(x)
        break
    s = 0
    x += 1
