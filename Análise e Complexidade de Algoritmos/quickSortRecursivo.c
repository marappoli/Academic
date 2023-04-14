#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void print_array(int v[], int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", v[i]);
    }
    printf("\n");
}

int partition(int v[], int p, int r) {
    int x = v[r];
    int i = p - 1;
    for (int j = p; j <= r - 1; j++) {
        if (v[j] <= x) {
            i++;
            int temp = v[i];
            v[i] = v[j];
            v[j] = temp;
        }
    }
    int temp = v[i + 1];
    v[i + 1] = v[r];
    v[r] = temp;
    return i + 1;
}

void quicksort(int v[], int p, int r) {
    if (p < r) {
        int q = partition(v, p, r);
        quicksort(v, p, q - 1);
        quicksort(v, q + 1, r);
    }
}

int main() {
    const int x = 1000;
    int v[x];
    srand(time(NULL));
    for (int i = 0; i < x; i++) {
        v[i] = rand() % 1000;
    }

    printf("Vetor desordenado: ");
    print_array(v, x);

    clock_t start, end;
    double cpu_time_used;
    start = clock();

    quicksort(v, 0, x-1);

    end = clock();
    cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;

    printf("Vetor ordenado: ");
    print_array(v, x);

    printf("Tempo de execução: %f segundos\n", cpu_time_used);
    return 0;
}
