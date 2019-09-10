// 10_4_3.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <iterator>
#include <list>

using namespace std;

int main()
{
	ostream_iterator<int> outer(cout, " ");
	// 10.34
	cout << "exercise 10.34: " << endl;
	vector<int> vi{ 1,2,3,4,5,6,7,8,9 };
	for (auto i = vi.rbegin(); i < vi.rend(); i++)
	{
		cout << *i << " ";
	}
	cout << endl;

	// 10.35
	cout << endl <<  "exercise 10.35: " << endl;
	for (auto i = vi.end(); i != vi.begin();)
	{
		cout << *(--i) << " ";
	}
	cout << endl;

	// 10.36
	cout << endl << "exercise 10.36: " << endl;
	list<int> li{ 1,2,3,4,5,6,7,8,0,1 };
	copy(li.begin(), li.end(), outer);
	cout << endl;
	auto idx = find(li.rbegin(), li.rend(), 0);
	idx++;
	int p = 1;
	for (auto i = li.begin(); i != idx.base(); i++, p++);

	cout << "The " << p << " th number is 0" << endl;

	// 10.37
	cout << endl << "exercise 10.37: " << endl;
	vector<int> v = { 1,2,3,4,5,6,7,8,9,10 };
	list<int> l;
	/*
	for (auto i = v.rbegin() + 2; i != v.rend() - 2; i++) {
		l.push_back(*i);
	}
	for (auto i : l)
	{
		cout << i << " ";
	}
	cout << endl;
	*/
	vector<int>::reverse_iterator re(v.begin() + 2);
	vector<int>::reverse_iterator rb(v.begin() + 8);
	copy(rb, re, back_inserter(l));
	copy(l.begin(), l.end(), outer);
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
