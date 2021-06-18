import sys

read = sys.stdin.readline
nlist = list(read().split())
n = 0
for i in range(1, 8):
    if (int(nlist[i]) - int(nlist[i - 1])) == 1:
        n += 1
    else:
        n += 0
    if (int(nlist[i - 1]) - int(nlist[i])) == 1:
        n += 9
    else:
        n += 0
if n == 7:
    print("ascending")
elif n == 63:
    print("descending")
else:
    print("mixed")
