// 9_3_1.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <deque>
#include <list>

using namespace std;

int main()
{
	// 9.18
	/*
	deque<string> ds;
	string s1;
	while (cin >> s1)
	{
		ds.push_back(s1);
	}
	for (auto beg = ds.begin(); beg != ds.end(); beg++)
	{
		cout << *beg << " ";
	}
	*/

	// 9.19
	/*
	list<string> ls;
	string s2;
	while (cin >> s2)
	{
		ls.push_back(s2);
	}
	for (auto beg = ls.begin(); beg != ls.end(); beg++)
	{
		cout << *beg << " ";
	}
	*/

	// 9.20
	list<int> li{ 0,1,2,3,4,5,6,7,8,9 };
	deque<int> di1;
	deque<int> di2;
	for (auto i: li)
	{
		if (i%2)
		{
			di1.push_back(i);
		}
		else
		{
			di2.push_back(i);
		}
	}
	cout << "odd numbers:";
	for (auto i:di1)
	{
		cout << " " << i;
	}
	cout << endl;

	cout << "even numbers:";
	for (auto i : di2)
	{
		cout << " " << i;
	}
	cout << endl;
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
