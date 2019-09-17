// 11_3_2.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <map>

using namespace std;

// 11.21
void add_child(multimap<string, string> &families, const string &family, const string& child) {
	families.insert({ family, child });
}

int main()
{
	// 11.20
	map<string, size_t> word_count;
	string word;
	while (cin >> word)
	{
		auto it = word_count.insert({ word, 1 });
		if (!it.second)
		{
			++it.first->second;
		}
	}
	for (const auto &i : word_count)
	{
		cout << i.first << " " << i.second << endl;
	}

	// 11.21
	multimap<string, string> families;
	add_child(families, "张", "强");
	add_child(families, "张", "刚");
	add_child(families, "王", "五");

	for (auto f : families)
	{
		cout << f.first << "家的孩子: " << f.second << endl;
	}
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
