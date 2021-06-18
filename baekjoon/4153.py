import sys

read = sys.stdin.readline
t = 0
while (1):
    x, y, z = map(int, read().split())
    if x==y==z==0:
        break
    if x > y and x > z:
        if x ** 2 == y ** 2 + z ** 2:
            t = 1
    elif y > z and y > x:
        if y ** 2 == x ** 2 + z ** 2:
            t = 1
    else:
        if z ** 2 == x ** 2 + y ** 2:
            t = 1
    if t==1:
        print("right")
    else:
        print("wrong")
    t=0
