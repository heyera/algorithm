import sys

read = sys.stdin.readline

L = int(read().rstrip())
l = list(read().rstrip())
sum = 0
for i in range(L):
    sum += (ord(l[i])-96) * 31 ** (i)
print(sum%1234567891)
