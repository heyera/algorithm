import sys

read = sys.stdin.readline
x, y, w, h = map(int, read().split())
reach=[]
reach.append(x)
reach.append(y)
reach.append(w-x)
reach.append(h-y)
print(min(reach))
