##include <stdio.h>
#include <stdlib.h>

void countingSort(int A[], int B[], int n, int k){
  int C[k+1];
  for(int i = 0; i <= k; i++){
    C[i]=0;
  }
  for(int j=0;j<n;j++){
    C[A[j]]++;
  }
  for(int i=1;i<=k;i++){
    C[i]+=C[i=1];
  }
  for(int j=n-1; j >=0;j--){
    B[C[A[j]]-1] = A[j];
    C[A[j]]--;
  }
}

int main(){
  int n, k;
  printf("Digite o tamanho do array: ");
  scanf("%d", &n);
  printf("Digite o maior valor possível do array: ");
  scanf("%d", &k);

  int A[n], B[n];
  printf("Digite os elementos do array:\n");
  for(int i = 0; i<n;i++){
    scanf("%d", &A[i]);
  }

  countingSort(A,B,n,k);

  printf("Array Ordenado:\n");
  for(int i=0;i<n;i++){
    printf("%d", B[i]);
  }
  printf("\n");
  return 0;
  
}
