#include <iostream>
using namespace std;
int add(int x, int y) {
	cout << "Let's add x and y: ";
	printf("%d\n",x+y);
	return x + y;
}

int main() 
{
	int i = 100;
	int *p = &i;
	cout << "p (i's address) equals " << p << endl;
	cout << "*p (i's value equals " << *p << endl;
}