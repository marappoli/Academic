#include <stdio.h>

void merge(int v[], int p[], int r[], int e, int d) {
    int i = 0, j = 0, k = 0;
    int v_temp[e + d];

    while (i < e && j < d) {
        if (p[i] <= r[j]) {
            v_temp[k++] = p[i++];
        } else {
            v_temp[k++] = r[j++];
        }
    }

    while (i < e) {
        v_temp[k++] = p[i++];
    }

    while (j < d) {
        v_temp[k++] = r[j++];
    }

    for (i = 0; i < k; i++) {
        v[i] = v_temp[i];
    }
}

void mergeSort(int v[], int tam) {
    if (tam <= 1) {
        return;
    }

    int q = tam / 2;
    int p[q], r[tam - q];

    for (int i = 0; i < q; i++) {
        p[i] = v[i];
    }
    for (int i = q; i < tam; i++) {
        r[i - q] = v[i];
    }

    mergeSort(p, q);
    mergeSort(r, tam - q);
    merge(v, p, r, q, tam - q);
}

int main() {
    int v[] = {4, 2, 7, 1, 3, 5, 6};
    int tam = sizeof(v) / sizeof(v[0]);

    printf("Inicial: ");
    for (int i = 0; i < tam; i++) {
        printf("%d ", v[i]);
    }
   printf("\n");

    mergeSort(v, tam);

    printf("\n");
    printf("Ordenada: ");
    for (int i = 0; i < tam; i++) {
        printf("%d ", v[i]);
    }
    printf("\n");

    return 0;
}
