import sys

read = sys.stdin.readline
while (1):
    a, b = map(int, read().split())
    if a == 0 and b == 0:
        break
    print(a + b)
