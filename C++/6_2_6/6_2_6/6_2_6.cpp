// 6_2_6.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <string>
using namespace std;

void error_msg(initializer_list<string> li) {
	for (auto beg = li.begin(); beg != li.end(); beg++)
	{
		cout << *beg << " ";
	}
	cout << endl;
}

/*
void error_msg(initializer_list<string> li) {
	for (auto val : li)
	{
		cout << val << " ";
	}
	cout << endl;
}
*/

// 6.27
int MySum(initializer_list<int> li) {
	int sum = 0;
	for (auto val : li)
	{
		sum += val;
	}
	return sum;
}



int main()
{
	string expected = "YES";
	string actual = "NO";
	if (expected != actual) {

		error_msg({ "functionX",expected, actual });
	}
	else
	{
		error_msg({ "functionX","Okay" });
	}

	cout << "sum of 1, 6, 9: " << MySum({ 1,6,9 }) << endl;
	cout << "sum of 4, 5, 9, 18: " << MySum({ 4,5,9,18 }) << endl;
	cout << "sum of 10, 10, 10, 10, 10, 10: " << MySum({ 10,10,10,10,10,10 }) << endl;
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
