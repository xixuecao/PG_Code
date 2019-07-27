// 6_7.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <vector>
using namespace std;

// 加法
int func1(int a, int b) {
	return a + b;
}
// 减法
int func2(int a, int b) {
	return a - b;
}
// 乘法
int func3(int a, int b) {
	return a * b;
}
// 除法
int func4(int a, int b) {
	return a / b;
}

int compute(int a, int b, int (*p)(int, int)) {
	return p(a, b);
}
int main()
{
	// 6.54
	vector<decltype(func1)*> vf;

	// 6.55
	decltype(func1)* p1 = func1, * p2 = func2, * p3 = func3, * p4 = func4;
	vf = { p1,p2,p3,p4 };

	// 6.56
	// vector里面只是一些函数，需要给入数值进行计算
	int a = 10, b = 5;
	for (auto i : vf)
	{
		cout << compute(a, b, i) << endl;
	}
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
