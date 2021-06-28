import sys

read = sys.stdin.readline
while (1):
    n = int(read().rstrip())
    if n < 1:
        break
    n1 = str(n)
    if n1== ''.join(reversed(n1)):
        print("yes")
    else:
        print("no")
