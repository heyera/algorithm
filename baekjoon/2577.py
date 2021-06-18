import sys

read = sys.stdin.readline
a = int(read().rstrip())
b = int(read().rstrip())
c = int(read().rstrip())
n = [0] * 10
for i in str(a * b * c):
    n[int(i)] += 1
for j in range(10):
    print(n[j])
