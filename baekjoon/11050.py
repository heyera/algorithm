import sys
from math import factorial

read = sys.stdin.readline
n, k = map(int, read().split())
print(factorial(n) // (factorial(k) * factorial(n - k)))
