import sys

read = sys.stdin.readline
a, b = read().split()
A=int(a[::-1])
B=int(b[::-1])
if A>B:
    print(A)
else:
    print(B)