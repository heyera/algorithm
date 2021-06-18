import sys

read = sys.stdin.readline
t = int(read())
for i in range(t):
    h, w, n = map(int, read().split())
    if n % h == 0:
        print('%d' % (h) + '%02d' % (int(n / h)))
    else:
        print('%d' % (n % h) + '%02d' % (int(n / h) + 1))
