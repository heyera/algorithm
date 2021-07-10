import sys

read = sys.stdin.readline
n = int(read())
lst = list(map(int, read().split()))
give = []
for _ in range(n):
    if len(set(lst)) == 1:
        give.append(50000 + (lst[0] * 5000))
    elif len(set(lst)) == 2:
        if lst[1] == lst[2]:
            give.append(10000 + (lst[3] * 1000))
        else:
            give.append(2000 + (lst[0] * 500) + (lst[2] * 500))
    elif len(set(lst)) == 3:
        if lst[1] == lst[2]:
            give.append(1000 + (lst[2] * 100))
        elif lst[0] == lst[1]:
            give.append(1000 + (lst[0] * 100))
        else:
            give.append(1000 + (lst[2] * 100))
    else:
        give.append(lst[3] * 100)

print(max(give))
