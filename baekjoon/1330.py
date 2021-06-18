import sys
read = sys.stdin.readline
a, b = map(int, read().split())
if (a < b):
    print('<')
elif (a > b):
    print('>')
elif (a == b):
    print('==')
