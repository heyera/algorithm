import sys

read = sys.stdin.readline
N = int(read().rstrip())
arr = [input() for _ in range(N)]
print(arr.sort())
