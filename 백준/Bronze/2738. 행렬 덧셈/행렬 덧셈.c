#include <stdio.h>

int main() {
    int N, M;
    scanf("%d %d", &N, &M);

    int A[100][100];
    int B[100][100];
    int result[100][100];

    // 입력받은 행렬 A의 원소를 읽음
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            scanf("%d", &A[i][j]);
        }
    }

    // 입력받은 행렬 B의 원소를 읽음
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            scanf("%d", &B[i][j]);
        }
    }

    // 두 행렬을 더하여 결과를 계산
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            result[i][j] = A[i][j] + B[i][j];
        }
    }

    // 결과 행렬을 출력
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            printf("%d", result[i][j]);
            if (j < M - 1) {
                printf(" ");
            }
        }
        printf("\n");
    }

    return 0;
}
