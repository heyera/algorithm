import sys

read = sys.stdin.readline
n = int(read().rstrip())
a = list(map(int, read().split()))
a_max = a_min = a[0]
for i in a:
    if a_min > i:
        a_min = i
    if a_max < i:
        a_max = i
print(a_min, a_max)
