import numpy as np 

pi = 3.14159265359
c = 3*10**8

print('\\\\MENU//')
print("Lâmbida (1)")
print("Frequência (2)")
print("Número de onda (3)")
print("Frequência Angular (4)")
print("Campo Magnético (5)")
print("Campo Elétrico (6)\n")
para = int(input("Insira o parâmetro: "))

if(para == 1):
  lambida = float(input("Insira o valor da Lâmbida (em metros): "))
  frequencia = c/lambida
  k = 2*pi/lambida
  w = 2*pi*frequencia
  print("Frequência: ")
  print(np.format_float_scientific(frequencia, unique= False, precision = 2),"Hz")
  print("\n")
  print("Numero de onda: ")
  print(np.format_float_scientific(k, unique= False, precision = 2),"rad/m")
  print("\n")
  print("Frequência Angular: ")
  print(np.format_float_scientific(w, unique= False, precision = 2),"rad/s")
  print("\n")
  
elif (para == 2):
  frequencia = float(input("Insira o valor da frequência (em Hz): \n"))
  lambida = c/frequencia
  k = 2*pi/lambida
  w = 2*pi*frequencia
  print("Lâmbida: ")
  print(np.format_float_scientific(lambida, unique= False, precision = 2),"m")
  print("\n")
  print("Numero de onda: ")
  print(np.format_float_scientific(k, unique= False, precision = 2),"rad/m")
  print("\n")
  print("Frequência Angular: ")
  print(np.format_float_scientific(w, unique= False, precision = 2),"rad/s")
  print("\n")
  
elif (para == 3):
  k = float(input("Insira o número de onda (em rad/m): "))
  lambida = 2*pi/k
  frequencia = c/lambida
  w = 2*pi*frequencia
  print("Lâmbida: ")
  print(np.format_float_scientific(lambida, unique= False, precision = 2),"m")
  print("\n")
  print("Frequência: ")
  print(np.format_float_scientific(frequencia, unique= False, precision = 2),"Hz")
  print("\n")
  print("Frequência Angular: ")
  print(np.format_float_scientific(w, unique= False, precision = 2),"rad/s")
  print("\n")
  
elif (para == 4):
  w = float(input("Insira o valor da Frequência Angular(em rad/s): "))
  k = w/c
  lambida = 2*pi/k
  frequencia = c/lambida
  
  print("Lâmbida: ")
  print(np.format_float_scientific(lambida, unique= False, precision = 2),"m")
  print("\n")
  print("Frequência: ")
  print(np.format_float_scientific(frequencia, unique= False, precision = 2),"Hz")
  print("\n")
  print("Numero de onda: ")
  print(np.format_float_scientific(k, unique= False, precision = 2),"rad/m")
  print("\n")
  
elif (para == 5):
  B = float(input("Insira o valor do Campo Elétrico (em T): "))
  E = B*c
  print("Campo Elétrico: ")
  print(np.format_float_scientific(E, unique= False, precision = 2),"V/m")
  print("\n")
  

elif (para == 6):
  E = float(input("Insira o valor do Campo Elétrico (em V/m): "))
  B = E/c
  print("Campo Magnético: ")
  print(np.format_float_scientific(B, unique= False, precision = 2),"T")
  print("\n")
