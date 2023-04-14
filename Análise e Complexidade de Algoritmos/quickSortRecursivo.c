#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define MAX_STACK_SIZE 1000

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

int partition(int arr[], int low, int high) {
    int pivot = arr[high]; 
    int i = low - 1; 

    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i + 1], &arr[high]);
    return (i + 1);
}

void iterativeQuickSort(int arr[], int l, int h) {
    int stack[MAX_STACK_SIZE]; 
    int top = -1;

    stack[++top] = l;
    stack[++top] = h;

    while (top >= 0) {
        h = stack[top--];
        l = stack[top--];

        int p = partition(arr, l, h);

        if (p - 1 > l) {
            stack[++top] = l;
            stack[++top] = p - 1;
        }

        if (p + 1 < h) {
            stack[++top] = p + 1;
            stack[++top] = h;
        }
    }
}

void printArray(int arr[], int low, int high) {
    for (int i = low; i <= high; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main() {
    const int x = 10000;
    int v[x];
    srand(time(NULL));
    for (int i = 0; i < x; i++) {
        v[i] = rand() % 10000;
    }

    printf("Vetor desordenado: ");
    printArray(v, 0, x-1);

    clock_t start, end;
    double cpu_time_used;
    start = clock();

    iterativeQuickSort(v, 0, x-1);

    end = clock();
    cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;

    printf("Vetor ordenado: ");
    printArray(v, 0, x-1);

    printf("Tempo de execução: %f segundos\n", cpu_time_used);
    return 0;
}
