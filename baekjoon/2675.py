import sys

read = sys.stdin.readline
t = int(read().rstrip())
for i in range(0, t):
    n, n_list = read().split()
    text=''
    for j in n_list:
        text+=j*int(n)
    print(text)