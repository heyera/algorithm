import sys

read = sys.stdin.readline
a = []
a_max = 0
for i in range(0, 9):
    a.append(int(read().strip()))
for j in a:
    if j > a_max:
        a_max = j
print(a_max)
print(a.index(a_max) + 1)
