import sys

read = sys.stdin.readline
l = [-1] * 26
S = str(read().rstrip())
w = 0
for i in S:
    if l[ord(i) - 97] == -1:
        l[ord(i) - 97] = w
    w += 1
for j in l:
    print(j, end=" ")
