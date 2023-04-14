import random
import time

def insertionSort(v):
  j = 0
  for j in range(len(v)):
    chave = v[j]
    i = j - 1
    while i >= 0 and v[i] > chave:
      v[i + 1] = v[i]
      i = i - 1
    v[i + 1] = chave
  return v
  #print(v)
  
x = 10 
v = random.sample(range(10), x)
print (v)
start = time.time()
v = insertionSort(v)
print (v)

end = time.time()
print(end - start)
