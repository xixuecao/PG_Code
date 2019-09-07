// 10_4_1.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <vector>
#include <list>
#include <algorithm>
#include <iterator>

using namespace std;

int main()
{
	// 10.27
	cout << "exercise 10.27: " << endl;
	vector<int> vi{ 1,2,3,4,5,6,7 };
	list<int> li, li1, li2, li3;

	unique_copy(vi.begin(), vi.end(), back_inserter(li));
	// unique_copy(vi.begin(), vi.end(), inserter(li, li.begin()));
	for (auto i : li)
	{
		cout << i << " ";
	}
	cout << endl;

	// 10.28
	cout << endl << "exercise 10.28: " << endl;
	vector<int> vis = { 1,2,3,4,5,6,7,8,9 };

	unique_copy(vis.begin(), vis.end(), front_inserter(li1));
	for (auto i : li1)
		cout << i << " ";
	cout << endl;

	unique_copy(vis.begin(), vis.end(), back_inserter(li2));
	for (auto i : li2)
		cout << i << " ";
	cout << endl;

	unique_copy(vis.begin(), vis.end(), inserter(li3, li3.begin()));
	for (auto i : li2)
		cout << i << " ";
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
