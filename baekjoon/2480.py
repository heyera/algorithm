import sys

read = sys.stdin.readline
a, b, c = map(int, read().split())
if a == b == c:
    give = 10000 + (a * 1000)
elif a == b or a == c:
    give = 1000 + (a * 100)
elif b == c :
    give = 1000 + (b * 100)
else:
    give = max(a, b, c) * 100
print(give)
