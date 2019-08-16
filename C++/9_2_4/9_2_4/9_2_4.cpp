// 9_2_4.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <vector>
#include <list>
using namespace std;

int main()
{
	// 9.11
	cout << "9.12" << endl;
	vector<int> l1(10);
	vector<int> l2(10, 5);
	vector<int> l3 = { 0,1,2,3,4,5,6,7,8,9 };
	vector<int> l4 = l3;
	vector<int> l5;
	vector<int> l6(l1.begin() + 2, l1.end());
	vector<vector<int>> lv1 = { l1,l2,l3,l4,l5,l6 };
	for (auto l:lv1)
	{
		for (auto i:l)
		{
			cout << i << " ";
		}
		cout << endl;
	}

	// 9.13
	cout << "9.13" << endl;
	list<int> li{ 1,2,3,4,5 };
	vector<double> vd1(li.begin(), li.end());
	vector<double> vd2(l3.begin(), l3.end());
	vector<vector<double>> lv2 = { vd1, vd2 };
	for (auto l : lv2)
	{
		for (auto i : l)
		{
			cout << i << " ";
		}
		cout << endl;
	}
	cout << vd1.capacity() << " " << vd1.size() << " " << vd1[0] << " " << vd1[vd1.size() - 1] << endl;
	cout << vd2.capacity() << " " << vd2.size() << " " << vd2[0] << " " << vd2[vd2.size() - 1] << endl;
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
