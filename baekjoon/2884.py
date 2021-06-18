import sys

read = sys.stdin.readline
a, b = map(int, read().split())
if 44 < b:
    print(a, b - 45)
elif a>0 and 45 > b:
    print(a - 1, b + 15)
else:
    print(23, b + 15)
