#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_N 1000

int G[MAX_N][MAX_N];    
int d[MAX_N];  
bool cor[MAX_N]; 
int p[MAX_N];
int L[MAX_N][MAX_N];

int fila[MAX_N]; 
int inicio_fila, fim_fila;

void BFS(int s, int n){

    inicio_fila = fim_fila = 0;
    fila[fim_fila++] = s; 
    d[s] = 0; 
    cor[s] = true; 

    while(inicio_fila < fim_fila){ 

        int u = fila[inicio_fila++];

        for(int i = 0; i < n; i++){ 
            if(G[u][i] && !cor[i]){ 

                cor[i] = true; 
                d[i] = d[u] + 1; 
                p[i] = u; 

                fila[fim_fila++] = i; 
            }
        }
    }
}
int main(){

    int N, M, X, Y;

    scanf("%d %d", &N, &M);

    for(int i = 0; i < M; i++){
        scanf("%d %d", &X, &Y);
        G[X][Y] = G[Y][X] = 1; 
    }

    for(int i = 0; i < N; i++){
        d[i] = -1;
        cor[i] = false; 
        p[i] = -1;
    }

    BFS(0, N); 

    printf("Distancias:\n");
    for(int i = 0; i < N; i++) printf("%d ", d[i]);
    printf("\n");

    return 0;
}
