#include <stdio.h> 

int main() {
	int nums[42] ={0};
	int answer = 0;

	for (int i = 0; i < 10; i++) {
		int n;
		scanf("%d", &n);
		nums[n % 42] = 1;
	}

	for (int i = 0; i < 42; i++) {
		if (nums[i] == 1) answer++;
	}

	printf("%d", answer);
    
    return 0;
}