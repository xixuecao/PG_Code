// 6_2_4.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
using namespace std;

// 6.21
int Larger(const int a, const int* b) {
	return (a > *b) ? a : *b;
}

// 6.22
void swap(int* a, int* b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}

// 6.23
void print1(const int* p) {
	cout << *p << endl;
}
void print2(const int* p, const int sz) {
	int i = 0;
	while (i != sz)
	{
		cout << *p++ << endl;
		++i;
	}
}
void print3(const int* b, const int* e) {
	for (auto p = b; p != e; p++)
	{
		cout << *p << endl;
	}
}

int main()
{
	int i = 0, j[2] = { 0,1 };
	print1(&i);
	print1(j);
	print2(&i, 1);

	print2(j, sizeof(j) / sizeof(*j));
	auto b = begin(j);
	auto e = end(j);
	print3(b, e);
	return 0;

}

// 运行程序: Ctrl + F5 或调试 >“开始执行(不调试)”菜单
// 调试程序: F5 或调试 >“开始调试”菜单

// 入门使用技巧: 
//   1. 使用解决方案资源管理器窗口添加/管理文件
//   2. 使用团队资源管理器窗口连接到源代码管理
//   3. 使用输出窗口查看生成输出和其他消息
//   4. 使用错误列表窗口查看错误
//   5. 转到“项目”>“添加新项”以创建新的代码文件，或转到“项目”>“添加现有项”以将现有代码文件添加到项目
//   6. 将来，若要再次打开此项目，请转到“文件”>“打开”>“项目”并选择 .sln 文件
