// 11_3_5.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <map>
#include <vector>

using namespace std;

int main()
{
	map<string, vector<int>> msv;
	msv["1"] = { 1,2,3 };
	map<string, vector<int>>::iterator it;
	it = msv.find("1");

	cout << it->first;
	for (auto i:it->second)
	{
		cout << " " << i;
	}
	cout << endl;

	// 11.31
	cout << endl << "exercise 11.31" << endl;
	multimap<string, string> books;
	books.insert({ "LuBo", "My Life" });
	books.insert({ "LuBo", "WiFi" });
	books.insert({ "Soul", "Life" });
	books.insert({ "Soul", "Time Life" });

	for (auto i:books)
	{
		cout << i.first << ", <<" << i.second << ">>" << endl;
	}
	cout << endl;

	/*
	auto size = books.count("LuBo");
	auto iter = books.find("LuBo");
	if (iter == books.end())
	{
		cout << "No author" << endl;
	}
	else
	{
		while (size)
		{
			books.erase(iter++);
			size--;
		}
	}
	*/

	auto pos = books.equal_range("LuBo");
	if (pos.first == pos.second)
	{
		cout << "No author" << endl;
	}
	else
	{
		books.erase(pos.first, pos.second);
	}

	for (auto i : books)
	{
		cout << i.first << ", <<" << i.second << ">>" << endl;
	}
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
