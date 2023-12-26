#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(long long n) {
    scanf("%d", &n);
    int cnt = 0;
    while (n != 1 && cnt < 500) {
        if(n % 2 == 0) {
            n = n / 2;
            cnt++;
        }
        else if (n % 2 == 1){
            n = n * 3 + 1;
            cnt++;
        }
    }
    if(cnt >= 500) {
        cnt = -1;
    }
    return cnt;
}