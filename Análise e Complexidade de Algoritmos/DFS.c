#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_N 100000

int G[MAX_N][MAX_N];
int d[MAX_N];
bool cor[MAX_N];
int p[MAX_N];

int S[MAX_N];
int top = -1;

void DFS(int i, int N){

    S[++top] = i;
    d[i] = 0;
    cor[i] = true;

    while(top != -1){

        int u = S[top--];

        for(int j = 0; j < N; j++){
            if(G[u][j] && !cor[j]){

                cor[j] = true;
                d[j] = d[u] + 1;
                p[j] = u;

                S[++top] = j;
            }
        }
    }
}

int main(){

    int N, M, X, Y;

    scanf("%d %d", &N, &M);

    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            G[i][j] = 0;
        }
    }

    for(int i = 0; i < M; i++){
        scanf("%d %d", &X, &Y);
        G[X][Y] = G[Y][X] = 1;
    }

    for(int i = 0; i < N; i++){
        d[i] = -1;
        cor[i] = false;
        p[i] = -1;
    }

    DFS(0, N);

    printf("Distancias:\n");
    for(int i = 0; i < N; i++){
        printf("%d ", d[i]);
    }
    printf("\n");

    return 0;
}
