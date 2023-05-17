#include<stdio.h>

int main() {
	int N;
	int ary[2], temp;
	int i = 0;
	int count = 0;
	scanf("%d", &N);
	
	ary[0] = N / 10;
	ary[1] = N % 10;
	temp = ary[0] + ary[1];
	ary[0] = ary[1];
	ary[1] = temp%10;
	count++;

	while (N != ary[0] * 10 + ary[1]) {
		temp = ary[0] + ary[1];
		ary[0] = ary[1];
		ary[1] = temp % 10;
		count++;
	}
	printf("%d", count);
}