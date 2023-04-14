#include <stdio.h>
#include <stdlib.h>

void counting_sort(int arr[], int n, int exp) {
    int i, output[n], count[10] = {0};

    for (i = 0; i < n; i++) {
        count[(arr[i] / exp) % 10]++;
    }

    for (i = 1; i < 10; i++) {
        count[i] += count[i-1];
    }

    for (i = n-1; i >= 0; i--) {
        int index = (arr[i] / exp) % 10;
        output[count[index]-1] = arr[i];
        count[index]--;
    }

    for (i = 0; i < n; i++) {
        arr[i] = output[i];
    }
}

int max_digit(int arr[], int n) {
    int max = 0, i;
    for (i = 0; i < n; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}

void msd_sort(int arr[], int n, int exp) {
    if (exp <= 0) {
        return;
    }

    int max = max_digit(arr, n);
    int divisor = 1;

    while (max / divisor > 0) {
        counting_sort(arr, n, divisor);
        divisor *= 10;
    }
}

int main() {
    int n, i;
    printf("Digite o tamanho do vetor: ");
    scanf("%d", &n);
    int arr[n];

    printf("Digite os elementos do vetor:\n");
    for (i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    msd_sort(arr, n, 1000000);

    printf("\nVetor ordenado:\n");
    for (i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    return 0;
}
