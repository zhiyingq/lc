#include <iostream>
using namespace std;
int add(int x, int y) {
	cout << "Let's add x and y: ";
	printf("%d\n",x+y);
	return x + y;
}

void createarray() {
	int a[4][4];
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			a[i][j] = 4 * i + j;
			printf("a[%d][%d] = %d \t",i,j,a[i][j]);
		}
		printf("\n");
	}
}

int main() 
{
	createarray();
	return 0;
}