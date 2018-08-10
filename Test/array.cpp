#include<iostream>
using namespace std;

// 利用指针变量获取数组中的元素并打印
// 如果p指向a中的一个元素，则p+1指向
int main() {
	int i, a[10];
	for (i = 0; i < 10; i++) {
		a[i] = i;
	}
	int *p[10];

	for (i = 0; i < 10; i++) {
		p[i] = &a[i];
		cout << "a[" << i <<"] = "<<a[i];
		cout << " it's address = "<<p[i]<<endl;
	}
	return 1;
}