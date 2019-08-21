// 9_3_4.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <forward_list>

using namespace std;

// 9.28
void insert_follow(forward_list<string> &flst,const string& s1,const string& s2) {
	bool flag = 1;
	auto prev = flst.before_begin();
	auto curr = flst.begin();
	while (curr != flst.end())
	{
		if (*curr == s1) {
			flag = 0;
			curr = flst.insert_after(curr, s2);
		}
		else
			prev = curr;
			curr++;
	}
	if (flag)
	{

		flst.insert_after(prev, s2);
	}
}

int main()
{
	// 9.27
	cout << "exercise 9.27: " << endl;
	forward_list<int> flst{ 0,1,2,3,4,5,6,7,8,9 };
	auto prev = flst.before_begin();
	auto curr = flst.begin();
	while (curr != flst.end())
	{
		if (*curr % 2) {
			curr = flst.erase_after(prev);
		}
		else
		{
			prev = curr;
			curr++;
		}
	}
	for (auto i : flst) {
		cout << i << " ";
	}

	// 9.28
	cout << endl << "exercise 9.28: " << endl;
	forward_list<string> st{"Hi,", "My", "name", "is", "your", "name?" };
	insert_follow(st, "is", "LUBO");
	for (auto i : st)
	{
		cout << i << " ";
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
