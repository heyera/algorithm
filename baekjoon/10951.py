import sys

read = sys.stdin.readline
while (1):
    try:
        a, b = map(int, read().split())
        print(a + b)
    except:
        break
