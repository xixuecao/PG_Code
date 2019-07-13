// 3_4_1.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <string>
#include <vector>
#include <ctime>
using namespace std;

int main()
{
	// 3.22
	/*
	vector<string> text;
	string s;
	while (getline(cin,s))
	{
		text.push_back(s);
	}
	for (auto it = text.begin(); it != text.end(); it++)
	{
		for (auto i = it->begin(); i != it->end(); i++)
		{
			*i = toupper(*i);
		}
		cout << *it << endl;
	}
	return 0;
	*/
	// 3.23
	vector<int> vi;
	// 输入10个数字
	/*
	int it;
	while (cin>>it)
	{
		vi.push_back(it);
	}
	*/
	// 随机生成1000以内的数
	srand((unsigned)time(NULL));
	for (int i = 0; i < 10; i++)
	{
		vi.push_back(rand() % 1000);
	}
	for (auto i = vi.begin(); i != vi.end(); i++)
	{
		cout << *i << " ";
	}

	cout << endl;
	for (auto i = vi.begin(); i != vi.end(); i++)
	{
		*i = 2 * (*i);
		cout << *i << " ";
	}
	return 0;
}

// 运行程序: Ctrl + F5 或调试 >“开始执行(不调试)”菜单
// 调试程序: F5 或调试 >“开始调试”菜单

// 入门提示: 
//   1. 使用解决方案资源管理器窗口添加/管理文件
//   2. 使用团队资源管理器窗口连接到源代码管理
//   3. 使用输出窗口查看生成输出和其他消息
//   4. 使用错误列表窗口查看错误
//   5. 转到“项目”>“添加新项”以创建新的代码文件，或转到“项目”>“添加现有项”以将现有代码文件添加到项目
//   6. 将来，若要再次打开此项目，请转到“文件”>“打开”>“项目”并选择 .sln 文件
