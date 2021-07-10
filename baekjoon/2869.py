import sys
import math

read = sys.stdin.readline
a, b, v = map(int, read().split(" "))
day = 1
x = a - b
y = v - a
day += math.ceil(y / x)

print(day)
