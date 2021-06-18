import sys

read = sys.stdin.readline
n = int(read().rstrip())
nc = read().split()
m=0
sum=0
for i in nc:
    if int(i)>m:
        m=int(i)
for j in nc:
    sum+=int(j)/m*100
print(sum/n)
