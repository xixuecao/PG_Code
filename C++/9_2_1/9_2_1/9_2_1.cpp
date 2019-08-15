// 9_2_1.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <vector>
using namespace std;

// 9.4

bool search_vec9_4(vector<int>::iterator beg, vector<int>::iterator end, int a) {
	while (beg != end)
	{
		if (*beg == a)
		{
			return true;
		}
		beg++;
	}
	return false;
}

// 9.5

vector<int>::iterator search_vec9_5(vector<int>::iterator beg, vector<int>::iterator end, int a) {
	while (beg != end)
	{
		if (*beg == a)
		{
			return beg;
		}
		beg++;
	}
	return end;
}
int main()
{
	// 9.4
	vector<int> ilist = { 1,2,3,4,5,6,7 };
	cout << search_vec9_4(ilist.begin(), ilist.end(), 3) << endl;
	cout << search_vec9_4(ilist.begin(), ilist.end(), 8) << endl;

	// 9.5
	cout << search_vec9_5(ilist.begin(), ilist.end(), 3) - ilist.end() << endl;
	cout << search_vec9_5(ilist.begin(), ilist.end(), 8) - ilist.end() << endl;
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
