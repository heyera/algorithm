import sys

read = sys.stdin.readline
n, x = map(int, read().split())
A = list(read().split())
B = [a for a in A if int(a) < x]
for i in B:
    print(i, end=" ")
