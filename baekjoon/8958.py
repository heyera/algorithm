import sys

read = sys.stdin.readline
n = int(read())
for i in range(n):
    inText = list(read().rstrip())
    sum = 0
    plus = 1
    for j in inText:
        if j == 'O':
            sum += plus
            plus += 1
        else:
            plus = 1
    print(sum)
