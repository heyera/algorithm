import sys

read = sys.stdin.readline
N = int(read())
name = 666
cnt = 0
while (1):
    if "666" in str(name):
        cnt += 1
        if cnt == N:
            print(name)
            break
    name += 1
