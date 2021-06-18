import sys

read = sys.stdin.readline
a= list(read().split())
sum=0
for x in a:
    sum= int(x)**2+sum
print(sum%10)