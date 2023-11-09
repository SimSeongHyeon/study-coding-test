#include <stdio.h>

int main() {
    int nums[1001] = {0}; // 배열 크기를 1001로 설정
    int answer = 0;

    for (int i = 0; i < 10; i++) {
        int n;
        scanf("%d", &n);
        
        if (n >= 0 && n <= 1000) { // 입력 범위 확인
            nums[n % 42] = 1;
        }
    }

    for (int i = 0; i < 42; i++) { // 42로 나누기
        if (nums[i] == 1) answer++;
    }

    printf("%d", answer);

    return 0;
}