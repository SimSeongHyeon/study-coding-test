#include <stdio.h>

int main() {
	char characters[5][16] = { 0 };

	for (int i = 0; i < 5; i++) {
		scanf("%s", characters[i]);
	}

	for (int i = 0; i < 15; i++) {
		for (int j = 0; j < 5; j++) {
			if (characters[j][i] != '\0') printf("%c", characters[j][i]);
		}
	}
}