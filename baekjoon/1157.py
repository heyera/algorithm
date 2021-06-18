import sys

read = sys.stdin.readline
text=read().rstrip().upper()
word=list(set(text))
cnt=[]
for i in word:
    x=text.count(i)
    cnt.append(x)
if cnt.count(max(cnt))>=2:
    print("?")
else:
    print(word[cnt.index(max(cnt))])