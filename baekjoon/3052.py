import sys

read = sys.stdin.readline
n = []
count = 0
for i in range(10):
    x = int(read().rstrip())
    n.append(x % 42)
print(len(list(set(n))))